package com.example.android.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.news.data.Article;
import com.example.android.news.networking.GetArticles;
import com.example.android.news.databinding.FragmentBinding;

import java.util.List;


public class EntertainmentFragment extends Fragment {

    private static final String TAG = "EntertainmentFragment" ;
    private FragmentBinding binding;
    private static boolean isDataNotLoaded = true;

    public EntertainmentFragment() {
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
        if(isDataNotLoaded){
            GetArticles.getArticles("entertainment",sharedViewModel);
            isDataNotLoaded = false;
        }
        NewsAdapter adapter = new NewsAdapter(null);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);
        sharedViewModel.getEntertainmentLiveData().observe(getViewLifecycleOwner(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> list) {
                Log.i(TAG, "onChanged: Entertainment");
                binding.progressBar.setVisibility(View.GONE);
                adapter.setList(list);
            }
        });

    }
}