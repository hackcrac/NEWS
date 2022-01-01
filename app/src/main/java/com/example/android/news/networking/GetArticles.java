package com.example.android.news.networking;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.android.news.data.Article;
import com.example.android.news.data.Json;
import com.example.android.news.SharedViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetArticles {
    private static final String TAG = "GetArticles";
    private static final  String apiKey = "cefa87a5dd07420a9c861423ed9cbec4";
    private static final String baseUrl = "https://newsapi.org/";
    private static final Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static final WebService service = retrofit.create(WebService.class);


    public static void getArticles(String query , SharedViewModel sharedViewModel){
        Call<Json> jsonCall = service.JsonRepos(query,apiKey);
        jsonCall.enqueue(new Callback<Json>() {
            @Override
            public void onResponse(@NonNull Call<Json> call, @NonNull Response<Json> response) {
                if(!response.isSuccessful()){
                    Log.i(TAG, "onResponse: "+response.errorBody());
                    return;
                }

                List<Article> list = response.body().getArticles();
                Log.i(TAG, "onResponse: "+list.size());

                switch (query){
                    case "general": sharedViewModel.setGeneralLiveData(list);
                        break;
                    case "entertainment": sharedViewModel.setEntertainmentLiveData(list);
                        break;
                    case "business": sharedViewModel.setBusinessLiveData(list);
                        break;
                    case "health": sharedViewModel.setHealthLiveData(list);
                        break;
                    case "science": sharedViewModel.setScienceLiveData(list);
                        break;
                    case "sports": sharedViewModel.setSportsLiveData(list);
                        break;
                    case "technology": sharedViewModel.setTechnologyLiveData(list);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Json> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t.getMessage());
            }
        });

    }
}
