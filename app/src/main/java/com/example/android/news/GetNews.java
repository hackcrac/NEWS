package com.example.android.news;

import android.util.Log;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;
import java.util.List;

public class GetNews {
    private static final String TAG = "Get News";

    public static void getNews(String query,SharedViewModel sharedViewModel){
        NewsApiClient newsApiClient = new NewsApiClient("cefa87a5dd07420a9c861423ed9cbec4");
        List<News> list = new ArrayList<>();
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(query)
                        .language("en")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        int totalArticles = response.getArticles().size();
                        Log.i(TAG, "onSuccess: "+totalArticles);
                        for (int i = 0; i < totalArticles; i++) {
                            String title = response.getArticles().get(i).getTitle();
                            String urlToImage = response.getArticles().get(i).getUrlToImage();
                            list.add(new News(title, urlToImage));
                        }
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
                    public void onFailure(Throwable throwable) {
                        Log.i(TAG, "onFailure: "+throwable.getMessage());
                    }
                }
        );
    }
}
