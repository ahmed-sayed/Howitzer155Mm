package com.example.android.howitzer155mm;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Find the view pager that will allow the user to swipe between fragments
        ViewPager mviewpager = (ViewPager) findViewById(R.id.viewpager);


        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter mFragmentAdapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());


        // Set the adapter onto the view pager
        mviewpager.setAdapter(mFragmentAdapter);



        //////////////////////////////
        //   TODO  :  // Connect the tab layout with the view pager. This will
        // 1. Update the tab layout when the view pager is swiped
        // 2. Update the view pager when a tab is selected
        // 3. Set the tab layout's tab names with the view pager's adapter's titles
        // by calling onPageTitle()
        ////////////////////////////


        // find the tab layout that shows the tabs
        android.support.design.widget.TabLayout tabLayout = (android.support.design.widget.TabLayout) findViewById(R.id.sliding_tabs);


        tabLayout.setupWithViewPager(mviewpager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        //

    }
}
