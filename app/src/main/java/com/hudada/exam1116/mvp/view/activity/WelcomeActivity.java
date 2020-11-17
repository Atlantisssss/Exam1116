package com.hudada.exam1116.mvp.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.hudada.exam1116.R;
import com.hudada.exam1116.mvp.view.fragment.LoginFragment;
import com.hudada.exam1116.mvp.view.fragment.ReFragment;
import com.hudada.exam1116.mvp.view.fragment.RegisterFragment;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    private ViewPager viewpagerId;
    private List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        boolean aBoolean = getSharedPreferences("user", MODE_PRIVATE).getBoolean("islogin", false);
        if(aBoolean){
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        list.add(new LoginFragment());
        list.add(new ReFragment());
        list.add(new RegisterFragment());
        viewpagerId = (ViewPager) findViewById(R.id.viewpager_id);
        viewpagerId.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });


    }
}
