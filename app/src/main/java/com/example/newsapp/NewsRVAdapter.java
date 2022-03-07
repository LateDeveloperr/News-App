package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {

    private ArrayList<Articles> articlesArrayList;
    private Context context;
    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
     return new NewsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.ViewHolder holder, int position) {
    Articles articles=articlesArrayList.get(position);
    holder.subtitleTV.setText(articles.getDescription());
    holder.titleTV.setText(articles.getTitle());
    Picasso.get().load(articles.getUrlToImage().into(holder.newsIV));
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i= new Intent(context,NewsDetaillActivity.class);
            i.putExtra("title",articles.getTitle());
            i.putExtra("content",articles.getContent());
            i.putExtra("description",articles.getDescription());
            i.putExtra("url",articles.getUrl());
            i.putExtra("image",articles.getUrlToImage());
            context.startActivity(i);




        }
    });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV,subtitleTV;
        private ImageView newsIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV=itemView.findViewById(R.id.idTVNewsHeading);
            subtitleTV=itemView.findViewById(R.id.idIVNewsSubHeading);
            newsIV=itemView.findViewById(R.id.idIVNews);
        }
    }
}
