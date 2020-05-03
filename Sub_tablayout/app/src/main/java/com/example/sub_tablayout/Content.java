package com.example.sub_tablayout;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Content extends Fragment {

    ListView listView;

    String[] contet;
    String pos;

    public Content(String pos,String[] content) {
        // Required empty public constructor
        this.contet=content;
        this.pos=pos;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_content, container, false);
        getActivity().setTitle(pos);

        listView=(ListView) view.findViewById(R.id.list_content);

        ArrayList<String> arr_cotent=new ArrayList<>();

        for (int i=0;i<contet.length;i++)
        {
            arr_cotent.add(contet[i]);
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                arr_cotent
        );
        listView.setAdapter(arrayAdapter);
        return view;
    }

}