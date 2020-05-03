package com.example.sub_tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s="subject";
        ListView listView=(ListView) findViewById(R.id.lisview);
        final String[] subjects=getResources().getStringArray(R.array.subject);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<String> arr_cotent=new ArrayList<>();

        for (int i=0;i<subjects.length;i++)
        {
            arr_cotent.add(subjects[i]);
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                arr_cotent
        );

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),tablayout.class);
                String pos=Integer.toString(position);
                intent.putExtra("data",subjects[position]);
                startActivity(intent);

            }
        });
    }
}
