package com.example.android.news;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.news.data.Article;
import com.example.android.news.databinding.ListItemBinding;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Article> list;

    public NewsAdapter(List<Article> list){
        this.list = list;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemBinding listItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false);
        return new ViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.listItemBinding.setArticle(list.get(position));
        holder.listItemBinding.executePendingBindings();
    }

    public void setList(List<Article> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(list==null){
            return 0;
        }
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding listItemBinding;
        public ViewHolder(@NonNull ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;
        }
    }
}
