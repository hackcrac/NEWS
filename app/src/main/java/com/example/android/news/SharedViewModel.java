package com.example.android.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.news.data.Article;

import java.util.List;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<List<Article>> generalLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Article>> entertainmentLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Article>> businessLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Article>> healthLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Article>> scienceLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Article>> sportsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Article>> technologyLiveData = new MutableLiveData<>();

    public void setGeneralLiveData(List<Article> list) {
        generalLiveData.setValue(list);
    }

    public void setEntertainmentLiveData(List<Article> list) {
        entertainmentLiveData.setValue(list);
    }

    public void setBusinessLiveData(List<Article> list) {
        businessLiveData.setValue(list);
    }

    public void setHealthLiveData(List<Article> list) {
        healthLiveData.setValue(list);
    }

    public void setScienceLiveData(List<Article> list) {
        scienceLiveData.setValue(list);
    }

    public void setSportsLiveData(List<Article> list) {
        sportsLiveData.setValue(list);
    }

    public void setTechnologyLiveData(List<Article> list) {
        technologyLiveData.setValue(list);
    }

    public LiveData<List<Article>> getGeneralLiveData() {
        return generalLiveData;
    }

    public LiveData<List<Article>> getEntertainmentLiveData() {
        return entertainmentLiveData;
    }

    public LiveData<List<Article>> getBusinessLiveData() {
        return businessLiveData;
    }

    public LiveData<List<Article>> getHealthLiveData() {
        return healthLiveData;
    }

    public LiveData<List<Article>> getScienceLiveData() {
        return scienceLiveData;
    }

    public LiveData<List<Article>> getSportsLiveData() {
        return sportsLiveData;
    }

    public LiveData<List<Article>> getTechnologyLiveData() {
        return technologyLiveData;
    }


}
