package com.example.android.newyork;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnaud Casamé on 6/13/2018.
 */

public class FixedPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<Fragment>();
    private final List<String> fragmentListTitles = new ArrayList<String>();

    public FixedPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentListTitles.add(title);
    }
}
