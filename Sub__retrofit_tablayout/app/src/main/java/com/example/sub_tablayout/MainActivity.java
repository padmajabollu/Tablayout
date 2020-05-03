package com.example.sub_tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;
    List<subData> subjects=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<List<subData>> call=ApiClient.getInstance().getApi().getSubjects("subject");
        call.enqueue(new Callback<List<subData>>() {
            @Override
            public void onResponse(Call<List<subData>> call, Response<List<subData>> response) {
                subjects=response.body();
                final String[] subject=new String[subjects.size()];

                final int[] sub_id=new int[subjects.size()];

                for (int i=0;i<subjects.size();i++)
                {
                    subject[i]=subjects.get(i).getSubject();
                    sub_id[i]=subjects.get(i).getSub_id();

                    //Toast.makeText(getApplicationContext(),Integer.toString(sub_id[i]), Toast.LENGTH_SHORT).show();

                }
                ListView listView=(ListView) findViewById(R.id.lisview);
                toolbar=(Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);


                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
                        getBaseContext(),
                        android.R.layout.simple_list_item_1,
                        subject
                );

                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getApplicationContext(),tablayout.class);
                        String pos=Integer.toString(position);

                        intent.putExtra("data",Integer.toString(sub_id[position]));
                        intent.putExtra("sub",subject[position]);

                        startActivity(intent);

                    }
                });

            }

            @Override
            public void onFailure(Call<List<subData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();


            }
        });



    }
}
