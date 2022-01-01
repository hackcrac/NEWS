package com.example.android.news.data;

import java.util.List;

public class Json {
    private final String status;
    private final int totalResults;
    private final List<Article> articles;

    public Json(String status, int totalResults, List<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
