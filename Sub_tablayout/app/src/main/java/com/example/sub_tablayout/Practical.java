package com.example.sub_tablayout;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Practical extends Fragment {
    ListView listView;
String[] practical,practical_content;
    String pos;

    public Practical(String pos,String[] practical,String[] practical_content) {
        // Required empty public constructor
        this.pos=pos;

        this.practical=practical;
        this.practical_content=practical_content;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_practical, container, false);
        getActivity().setTitle(pos);
        listView=(ListView) view.findViewById(R.id.list_practical);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
        return  view;
    }

    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return practical.length;
        }

        @Override
        public Object getItem(int position) {
            return practical[position];
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

            t1.setText(practical[position]);
            t2.setText(practical_content[position]);

            return v;
        }
    }
}
