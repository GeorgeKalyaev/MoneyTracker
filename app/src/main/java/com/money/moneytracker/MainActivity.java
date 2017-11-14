package com.money.moneytracker;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.pages);
        TabLayout tabs = findViewById(R.id.tabs);

        pager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), getResources()));
        tabs.setupWithViewPager(pager);
        getApplication();
    }
}

