package com.example.retrofitexample.retrofit;

import com.example.retrofitexample.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/posts")
    Call<List<PostModel>> getAllPosts();

}
