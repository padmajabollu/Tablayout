package com.example.sub_tablayout;


import android.app.ActionBar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class Exam extends Fragment {

    TextView t1,t2,t3,t4,t5;
    int pos=0;
    List<examData> examDataList=new ArrayList<>();
    String sub;
    String[] exam;

    public Exam(int pos,String sub) {
        // Required empty public constructor
        this.pos=pos;
        this.sub=sub;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_exam, container, false);

        getActivity().setTitle(sub);

        t1=(TextView) view.findViewById(R.id.t1);
        t2=(TextView) view.findViewById(R.id.t2);
        t3=(TextView) view.findViewById(R.id.t3);
        t4=(TextView) view.findViewById(R.id.t4);
        t5=(TextView) view.findViewById(R.id.t5);

        Call<List<examData>> call=ApiClient.getInstance().getApi().getExam("exam",pos);
        call.enqueue(new Callback<List<examData>>() {
            @Override
            public void onResponse(Call<List<examData>> call, Response<List<examData>> response) {
                examDataList=response.body();

                exam=new String[5];

                for (int i=0;i<examDataList.size();i++)
                {
                    exam[0]=Integer.toString(examDataList.get(i).getIa());
                    exam[1]=Integer.toString(examDataList.get(i).getIse());
                    exam[2]=Integer.toString(examDataList.get(i).getEse());
                    exam[3]=Integer.toString(examDataList.get(i).getPractical());
                    exam[4]=Integer.toString(examDataList.get(i).getProject());
                }

                t1.setText(exam[0]);
                t2.setText(exam[1]);
                t3.setText(exam[2]);
                t4.setText(exam[3]);
                t5.setText(exam[4]);


            }

            @Override
            public void onFailure(Call<List<examData>> call, Throwable t) {

            }
        });




        return view;
    }

}
