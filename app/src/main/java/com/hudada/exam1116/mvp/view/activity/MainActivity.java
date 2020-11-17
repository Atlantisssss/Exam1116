package com.hudada.exam1116.mvp.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.hudada.exam1116.R;
import com.hudada.exam1116.mvp.view.fragment.CityFragment;
import com.hudada.exam1116.mvp.view.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewpagerId;
    private List<Fragment> f_list=new ArrayList<>();
    private List<String> s_list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f_list.add(new HomeFragment());
        f_list.add(new CityFragment());
        s_list.add("首页");
        s_list.add("同城");

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpagerId = (ViewPager) findViewById(R.id.viewpager_id);
        viewpagerId.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return f_list.get(position);
            }

            @Override
            public int getCount() {
                return f_list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return s_list.get(position);
            }
        });
        tablayout.setupWithViewPager(viewpagerId);
    }
}
