package com.example.sub_tablayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tablayout extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Intent data;
    public String[] exam,content,practical,practical_content;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        data=getIntent();
        pos=Integer.parseInt(data.getStringExtra("data"));
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager) findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        Intent data=getIntent();
        int pos=Integer.parseInt(data.getStringExtra("data"));
        String sub=data.getStringExtra("sub");
        //Toast.makeText(getApplicationContext(),Integer.toString(pos),Toast.LENGTH_SHORT).show();

        ViewpagerAdapter viewPagerAdapter=new ViewpagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Exam(pos,sub),"Exam");
        viewPagerAdapter.addFragment(new Content(pos,sub),"Content");
        viewPagerAdapter.addFragment(new Practical(pos,sub),"Practical");

        viewPager.setAdapter(viewPagerAdapter);

    }

}
