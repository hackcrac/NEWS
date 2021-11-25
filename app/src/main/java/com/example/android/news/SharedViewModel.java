package com.example.android.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<List<News>> generalLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<News>> entertainmentLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<News>> businessLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<News>> healthLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<News>> scienceLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<News>> sportsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<News>> technologyLiveData = new MutableLiveData<>();

    public void setGeneralLiveData(List<News> list){
        generalLiveData.setValue(list);
    }
    public void setEntertainmentLiveData(List<News> list){
        entertainmentLiveData.setValue(list);
    }
    public void setBusinessLiveData(List<News> list){
        businessLiveData.setValue(list);
    }
    public void setHealthLiveData(List<News> list){
        healthLiveData.setValue(list);
    }
    public void setScienceLiveData(List<News> list){
        scienceLiveData.setValue(list);
    }
    public void setSportsLiveData(List<News> list){
        sportsLiveData.setValue(list);
    }
    public void setTechnologyLiveData(List<News> list){
        technologyLiveData.setValue(list);
    }

    public LiveData<List<News>> getGeneralLiveData (){
        return generalLiveData;
    }
    public LiveData<List<News>> getEntertainmentLiveData (){
        return entertainmentLiveData;
    }
    public LiveData<List<News>> getBusinessLiveData (){
        return businessLiveData;
    }
    public LiveData<List<News>> getHealthLiveData (){
        return healthLiveData;
    }
    public LiveData<List<News>> getScienceLiveData (){
        return scienceLiveData;
    }
    public LiveData<List<News>> getSportsLiveData (){
        return sportsLiveData;
    }
    public LiveData<List<News>> getTechnologyLiveData (){
        return technologyLiveData;
    }


}
