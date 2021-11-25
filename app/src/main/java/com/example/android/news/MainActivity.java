package com.example.android.news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.example.android.news.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        PagerAdapter pagerAdapter = new PagerAdapter(this);
        binding.pager.setAdapter(pagerAdapter);

        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabLayout, binding.pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(fragmentName(position));
            }
        });

        mediator.attach();

    }

    private static class PagerAdapter extends FragmentStateAdapter {

        public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new GeneralFragment();
                case 1:
                    return new EntertainmentFragment();
                case 2:
                    return new BusinessFragment();
                case 3:
                    return new HealthFragment();
                case 4:
                    return new SportsFragment();
                case 5:
                    return new ScienceFragment();
                default:
                    return new TechnologyFragment();
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

    private String fragmentName(int position){
        switch (position) {
            case 0:
                return "General";
            case 1:
                return "Entertainment";
            case 2:
                return "Business";
            case 3:
                return "Health";
            case 4:
                return "Sports";
            case 5:
                return "Science";
            default:
                return "Technology";
        }
    }

}