package com.example.android.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.news.databinding.FragmentBinding;

import java.util.List;


public class HealthFragment extends Fragment {
    private static final String TAG = "HealthFragment" ;
    private FragmentBinding binding;
    private static boolean isDataLoaded = true;

    public HealthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil
                .inflate(inflater,R.layout.fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated: ");
        SharedViewModel sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        if(isDataLoaded){
            Handler handler = new Handler(Looper.getMainLooper());
            List<News> list = GetNews.getNews("health");
            handler.postDelayed(() -> {
                sharedViewModel.setHealthLiveData(list);
                isDataLoaded = false;
            },2000);
        }
        NewsAdapter adapter = new NewsAdapter(null);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);
        sharedViewModel.getHealthLiveData().observe(getViewLifecycleOwner(), new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> list) {
                Log.i(TAG, "onChanged: Health");
                binding.progressBar.setVisibility(View.GONE);
                adapter.setList(list);
            }
        });

    }
}