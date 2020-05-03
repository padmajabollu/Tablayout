package com.example.sub_tablayout;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Exam extends Fragment {

    TextView t1,t2,t3,t4,t5;
    String pos;

    String[] exam;
    public Exam(String pos,String[] exam) {
        // Required empty public constructor
        this.exam=exam;
        this.pos=pos;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_exam, container, false);
        getActivity().setTitle(pos);

        t1=(TextView) view.findViewById(R.id.t1);
        t2=(TextView) view.findViewById(R.id.t2);
        t3=(TextView) view.findViewById(R.id.t3);
        t4=(TextView) view.findViewById(R.id.t4);
        t5=(TextView) view.findViewById(R.id.t5);

        t1.setText(this.exam[0]);
        t2.setText(this.exam[1]);
        t3.setText(this.exam[2]);
        t4.setText(this.exam[3]);
        t5.setText(this.exam[4]);

        return view;
    }

}
