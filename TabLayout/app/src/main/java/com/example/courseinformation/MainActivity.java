package com.example.courseinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager) findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);


        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
       /* String[] exam=getResources().getStringArray(R.array.Exam);
        for (int i=0;i<exam.length;i++)
        {

            Toast.makeText(getApplicationContext(),exam[i],Toast.LENGTH_SHORT).show();

        }*/
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Exam(),"Exam");
        viewPagerAdapter.addFragment(new Content(),"Content");
        viewPagerAdapter.addFragment(new Practical(),"Practical");

        viewPager.setAdapter(viewPagerAdapter);

    }
}
