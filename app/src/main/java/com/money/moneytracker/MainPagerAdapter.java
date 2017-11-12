package com.money.moneytracker;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 06.11.2017.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final static int PAGE_EXPENSES = 0;
    private final static int PAGE_INCOMES = 1;
    private final static int PAGE_BALANCE = 2;



    private String[] titles;

    public MainPagerAdapter(FragmentManager fm, Resources resources) {
        super(fm);

        titles = resources.getStringArray(R.array.tabs_titles);
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case PAGE_EXPENSES:
                return itemsFragment.createItemsFragment(itemsFragment.TYPE_EXPENSE);

            case PAGE_INCOMES:
                return itemsFragment.createItemsFragment(itemsFragment.TYPE_INCOME);

            case PAGE_BALANCE:
                Fragment fragment = new BalanceFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(BalanceFragment.KEY_TYPE, BalanceFragment.TYPE_BALANCE);

                fragment.setArguments(bundle);
                return fragment;

                default:
                    return null;
        }
}

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];


    }
}
