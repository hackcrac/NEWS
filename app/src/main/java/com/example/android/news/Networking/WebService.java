package com.example.android.news.Networking;

import androidx.annotation.RequiresApi;

import com.example.android.news.Json.Json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebService {
    @GET("v2/everything")
    Call<Json> JsonRepos(@Query("q") String query,@Query("apiKey") String apiKey);
}
