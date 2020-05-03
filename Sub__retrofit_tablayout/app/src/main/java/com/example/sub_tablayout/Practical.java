package com.example.sub_tablayout;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Practical extends Fragment {
    ListView listView;
    List<practicalData> practicalDataList=new ArrayList<>();

    int pos;
    String sub;
    String[] practical,practical_content;

    public Practical(int pos,String sub) {
        // Required empty public constructor
        this.pos=pos;
        this.sub=sub;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_practical, container, false);
        getActivity().setTitle(sub);

        listView=(ListView) view.findViewById(R.id.list_practical);

        Call<List<practicalData>> call2=ApiClient.getInstance().getApi().getPractical("practical",pos);
        call2.enqueue(new Callback<List<practicalData>>() {
            @Override
            public void onResponse(Call<List<practicalData>> call, Response<List<practicalData>> response) {
                practicalDataList=response.body();

                practical=new String[practicalDataList.size()];
                practical_content=new String[practicalDataList.size()];

                for (int i=0;i<practicalDataList.size();i++)
                {
                    practical[i]=practicalDataList.get(i).getPractical_title();
                    practical_content[i]=practicalDataList.get(i).getPractical_content();

                }


        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Call<List<practicalData>> call, Throwable t) {

            }
        });

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
