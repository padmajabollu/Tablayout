package com.example.courseinformation;


import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Exam extends Fragment {

    TextView t1,t2,t3,t4,t5;
    public Exam() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_exam, container, false);

        t1=(TextView) view.findViewById(R.id.t1);
        t2=(TextView) view.findViewById(R.id.t2);
        t3=(TextView) view.findViewById(R.id.t3);
        t4=(TextView) view.findViewById(R.id.t4);
        t5=(TextView) view.findViewById(R.id.t5);

        String[] exam=getResources().getStringArray(R.array.Exam);

        t1.setText(": "+exam[0]);
        t2.setText(": "+exam[1]);
        t3.setText(": "+exam[2]);
        t4.setText(": "+exam[3]);
        t5.setText(": "+exam[4]);

        return view;
    }

}
