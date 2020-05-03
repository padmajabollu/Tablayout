package com.example.sub_tablayout;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("TablayoutSubRetrofit.php")
    Call<List<subData>> getSubjects(
            @Field("choice") String choice
    );

    @FormUrlEncoded
    @POST("TablayoutSubRetrofit.php")
    Call<List<examData>> getExam(
            @Field("choice") String choice,
            @Field("sub_id") int sub_id
    );
    @FormUrlEncoded
    @POST("TablayoutSubRetrofit.php")
    Call<List<contentData>> getContent(
            @Field("choice") String choice,
            @Field("sub_id") int sub_id
    );

    @FormUrlEncoded
    @POST("TablayoutSubRetrofit.php")
    Call<List<practicalData>> getPractical(
            @Field("choice") String choice,
            @Field("sub_id") int sub_id
    );

}
