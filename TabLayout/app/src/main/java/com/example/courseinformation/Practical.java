package com.example.courseinformation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Practical extends Fragment {

    String[] arr1,arr2;


    ListView listView;



    public Practical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_practical, container, false);
         arr1=getResources().getStringArray(R.array.Practical_Content);
         arr2=getResources().getStringArray(R.array.Practical);
        listView=(ListView) view.findViewById(R.id.list_practical);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
        return  view;
    }

    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return arr1.length;
        }

        @Override
        public Object getItem(int position) {
            return arr1[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=getLayoutInflater().inflate(R.layout.listviewlayout,null);
            TextView t1=(TextView) v.findViewById(R.id.t1);
            TextView t2=(TextView) v.findViewById(R.id.t2);

            t1.setText(arr2[position]);
            t2.setText(arr1[position]);

            return v;
        }
    }
}
