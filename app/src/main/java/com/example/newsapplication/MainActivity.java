package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome,mscience,mhealth,mtech,mentertainmnet,msports;
    PagerAdapter pageradpter;
    Toolbar mtoolbar;

    String api ="fff1b1688ce6438fb59dcdf143d56d35";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar =findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sports);
        mscience = findViewById(R.id.science);
        mhealth = findViewById(R.id.health);
        mentertainmnet = findViewById(R.id.entertainment);
        mtech = findViewById(R.id.technology);
        ViewPager viewPager =findViewById(R.id.fragmentContainer);
        tabLayout =findViewById(R.id.include);

        pageradpter = new PagerAdapter(getSupportFragmentManager() ,6);
        viewPager.setAdapter(pageradpter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition()==3
                        ||tab.getPosition()==4 ||tab.getPosition()==5 )
                {
                    pageradpter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}