package com.money.moneytracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class itemsFragment extends Fragment {

    private static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_EXPENSE = 0;
    public static final int TYPE_INCOME = 1;

    private static final String KEY_TYPE = "TYPE";

    private int type = TYPE_EXPENSE;

    public static itemsFragment createItemsFragment(int type){
        itemsFragment fragment = new itemsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(itemsFragment.KEY_TYPE, type);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_items, container, false);
       return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new itemsAdapter());

        type = getArguments().getInt(KEY_TYPE, TYPE_UNKNOWN);

        if (type == TYPE_UNKNOWN){
            throw new IllegalStateException("Unknown Fragment Type");
        }
    }
}
