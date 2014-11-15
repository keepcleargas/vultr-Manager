package com.zaozao.vultrManager.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.TextHttpResponseHandler;
import com.viewpagerindicator.TabPageIndicator;
import com.zaozao.vultrManager.R;
import com.zaozao.vultrManager.data.Instance;
import com.zaozao.vultrManager.fragments.InfoFragment;
import com.zaozao.vultrManager.http.HttpApi;
import com.zaozao.vultrManager.utils.ApiKeyStore;
import com.zaozao.vultrManager.utils.AppUtil;
import com.zaozao.vultrManager.utils.IConstant;
import com.zaozao.vultrManager.adapters.FragmentPagerAdapterEx;
import com.zaozao.vultrManager.fragments.TestFragment;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by chenqisheng on 14/11/15.
 */
public class InstanceActivity extends BaseActivity {
    final static int[] title = {R.string.server_info, R.string.usage_graph, R.string.ipv4, R.string.tool};
    @InjectView(R.id.tabPageIndicator)
    TabPageIndicator tabPageIndicator;
    @InjectView(R.id.viewPager)
    ViewPager viewPager;

    private FragmentPagerAdapterEx mPagerAdapter;
    private InfoFragment infoFragment;
    private TestFragment online;
    private TestFragment feedback;
    private TestFragment tool;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private Instance serverInfo;
    private String subId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instance);
        ButterKnife.inject(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            subId = bundle.getString(IConstant.PARAMS_SUBID);
        }
        tool = new TestFragment();
        infoFragment = new InfoFragment();
        online = new TestFragment();
        feedback = new TestFragment();


        fragmentList.add(infoFragment);
        fragmentList.add(online);
        fragmentList.add(feedback);
        fragmentList.add(tool);

        mPagerAdapter = new FragmentPagerAdapterEx(this, getSupportFragmentManager(), fragmentList, title);

        viewPager.setAdapter(mPagerAdapter);
        tabPageIndicator.setViewPager(viewPager);

        getInstance();
    }

    private void getInstance() {
        if (ApiKeyStore.getInstance().getApiKey(this).equals("")) {
            return;
        }
        HttpApi.getOneInstnce(this, subId, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                if (statusCode == 403) {
                    AppUtil.showToast(InstanceActivity.this, getString(R.string.api_key_not_valid));
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d(AppUtil.LOGTAG, "res:" + responseString);
                serverInfo = JSON.parseObject(responseString, Instance.class);
                infoFragment.setServerInfo(serverInfo);
            }
        });
    }
}
