package com.zaozao.vultrManager.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

public class FragmentPagerAdapterEx extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private FragmentManager fm;
    private int[] titles;
    private Context mContext;

    public FragmentPagerAdapterEx(Context mContext,FragmentManager fm) {
        super(fm);
        this.fm = fm;
        this.mContext = mContext;
    }

    public FragmentPagerAdapterEx(Context mContext,FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
        this.mContext = mContext;
    }

    public FragmentPagerAdapterEx(Context mContext,FragmentManager fm, List<Fragment> fragments, int[] titles) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
        this.titles = titles;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        Object obj = super.instantiateItem(container, position);
        return obj;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(titles!=null&&titles.length>0){
            return mContext.getResources().getString(titles[position]);
        }else{
            return "";
        }
    }
}
