package com.example.sub_tablayout;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Content extends Fragment {

    ListView listView;
    List<contentData> contentDataList=new ArrayList<>();
    int pos;
    String sub;
    ArrayList<String> content=new ArrayList<>();

    public Content(int pos, String sub) {
        // Required empty public constructor
        this.pos=pos;
        this.sub=sub;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_content, container, false);
        getActivity().setTitle(sub);

        listView=(ListView) view.findViewById(R.id.list_content);

        Call<List<contentData>> call1=ApiClient.getInstance().getApi().getContent("content",pos);
        call1.enqueue(new Callback<List<contentData>>() {
            @Override
            public void onResponse(Call<List<contentData>> call, Response<List<contentData>> response) {
                contentDataList=response.body();

                for (int i=0;i<contentDataList.size();i++)
                {
                    content.add(contentDataList.get(i).getUnit_title());
                    content.add(contentDataList.get(i).getUnit_content());


                }

                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        content
                );
                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onFailure(Call<List<contentData>> call, Throwable t) {

            }
        });


        return view;
    }

}