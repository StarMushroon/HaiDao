package com.jane.mybasis.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by StarMushroom on 2017/5/13.
 */

public abstract class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<String> title;
    private List<Fragment> mFragments;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<String> title, List<Fragment> fragments) {
        super(fm);
        this.title = title;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
