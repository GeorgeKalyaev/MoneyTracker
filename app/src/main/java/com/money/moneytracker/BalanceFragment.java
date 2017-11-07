package com.money.moneytracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by user on 07.11.2017.
 */

public class BalanceFragment extends Fragment {
    public static final int TYPE_BALANCE = 0;
    public static final String KEY_TYPE = "TYPE";

    private int type = TYPE_BALANCE;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.balance, container, false);
    }



}
