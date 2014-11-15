package com.zaozao.vultrManager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loopj.android.http.TextHttpResponseHandler;
import com.squareup.otto.Bus;
import com.zaozao.vultrManager.R;
import com.zaozao.vultrManager.adapters.InstanceAdapter;
import com.zaozao.vultrManager.data.Instance;
import com.zaozao.vultrManager.http.HttpApi;
import com.zaozao.vultrManager.utils.ApiKeyStore;
import com.zaozao.vultrManager.utils.AppUtil;
import com.zaozao.vultrManager.utils.BusProvider;
import com.zaozao.vultrManager.utils.IConstant;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    @InjectView(R.id.setting)
    LinearLayout setting;
    @InjectView(R.id.right_action)
    LinearLayout add;
    @InjectView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;
    @InjectView(R.id.listview)
    ListView listView;

    Bus bus = BusProvider.getBus();
    List<Instance> instanceList = new ArrayList<Instance>();
    InstanceAdapter instanceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getInstances();
            }
        });
        swipeRefreshLayout.setProgressBackgroundColor(android.R.color.holo_blue_bright);

        setting.setOnClickListener(this);
        bus.register(this);

        instanceAdapter = new InstanceAdapter(this, instanceList);
        listView.setAdapter(instanceAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Instance instance = (Instance) adapterView.getAdapter().getItem(i);
                Intent goToInfo = new Intent(MainActivity.this, InstanceActivity.class);
                goToInfo.putExtra(IConstant.PARAMS_SUBID, instance.getSubId());
                startActivity(goToInfo);
            }
        });
        getInstances();
    }

    private void getInstances() {
        if (ApiKeyStore.getInstance().getApiKey(this).equals("")) {
            return;
        }
        swipeRefreshLayout.setRefreshing(true);
        HttpApi.getInstances(this, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                if (statusCode == 403) {
                    AppUtil.showToast(MainActivity.this, getString(R.string.api_key_not_valid));
                }
                stopRefreshing();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d(AppUtil.LOGTAG, "res:" + responseString);
                instanceList.clear();
                stopRefreshing();
                JSONObject jsonObject = JSON.parseObject(responseString);
                for (String key : jsonObject.keySet()) {
                    JSONObject jsonObject1 = jsonObject.getJSONObject(key);
                    Instance instance = JSON.parseObject(jsonObject1.toJSONString(), Instance.class);
                    instanceList.add(instance);
                }
                instanceAdapter.notifyDataSetChanged();
            }
        });
    }

    private void stopRefreshing() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}

