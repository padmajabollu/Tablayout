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

public class tablayout extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    Intent data;

    String[] exam,content,practical,practical_content;
    String pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        data=getIntent();
        pos=data.getStringExtra("data");
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager) findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);

        String[] subjects=getResources().getStringArray(R.array.subject);

            if (pos.equals("MAD"))
            {

                exam=getResources().getStringArray(R.array.Exam_Mad);
                content=getResources().getStringArray(R.array.Content_Mad);
                practical=getResources().getStringArray(R.array.Practical_Mad);
                practical_content=getResources().getStringArray(R.array.Practical_Content_Mad);


            }
            else if (pos.equals("CT"))
            {

                exam=getResources().getStringArray(R.array.Exam_Ct);
                content=getResources().getStringArray(R.array.Content_Ct);
                practical=getResources().getStringArray(R.array.Practical_Ct);
                practical_content=getResources().getStringArray(R.array.Practical_Content_Ct);

            }

            else if (pos.equals("OS"))
            {

                exam=getResources().getStringArray(R.array.Exam_Os);
                content=getResources().getStringArray(R.array.Content_Os);
                practical=getResources().getStringArray(R.array.Practical_Os);
                practical_content=getResources().getStringArray(R.array.Practical_Content_Os);

            }

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
       
        ViewpagerAdapter viewPagerAdapter=new ViewpagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Exam(pos,exam),"Exam");
        viewPagerAdapter.addFragment(new Content(pos,content),"Content");
        viewPagerAdapter.addFragment(new Practical(pos,practical,practical_content),"Practical");

        viewPager.setAdapter(viewPagerAdapter);

    }

}
