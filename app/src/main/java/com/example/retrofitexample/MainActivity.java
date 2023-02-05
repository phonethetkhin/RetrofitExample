package com.example.retrofitexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitexample.adapter.PostAdapter;
import com.example.retrofitexample.model.PostModel;
import com.example.retrofitexample.retrofit.APIInterface;
import com.example.retrofitexample.retrofit.RetrofitObj;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMain = findViewById(R.id.rvMain);

        fetchData();


    }

    private void setAdapter(List<PostModel> postModelList) {
        rvMain.setAdapter(new PostAdapter(postModelList));
    }

    private void fetchData() {
        Retrofit retrofitObj = RetrofitObj.getRetrofitInstance();
        APIInterface apiInterface = retrofitObj.create(APIInterface.class);

        Call<List<PostModel>> postResponse = apiInterface.getAllPosts();
        postResponse.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if(response.isSuccessful()){
                    setAdapter(response.body());
                }else{
                    Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }
}