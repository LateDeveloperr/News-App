package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {
private ArrayList<CategoryRVAdapter> categoryRVAdapters;
private Context context;
private CatergorClickInterface catergorClickInterface;

    public CategoryRVAdapter(ArrayList<CategoryRVAdapter> categoryRVAdapters, Context context, CatergorClickInterface catergorClickInterface) {
        this.categoryRVAdapters = categoryRVAdapters;
        this.context = context;
        this.catergorClickInterface = catergorClickInterface;
    }

    @NonNull
    @Override
    public CategoryRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);
    return new CategoryRVAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRVAdapter.ViewHolder holder, int position) {
CategoryRVModal CategoryRVModal= com.example.newsapp.CategoryRVModal.get(position);
holder.categoryTV.setText(CategoryRVModal.getCategory());

        ObjectInputStream.GetField Picasso = null;
        Picasso.get().load(CategoryRVModal.getCategoryImageUrl()).into(holder.categoryIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catergorClickInterface.onCategorClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return CategoryRVModal.size();
    }

    public interface CatergorClickInterface{
        void OnCategoryClick(int position);

        void onCategorClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView categoryTV;
        private ImageView categoryIV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTV=itemView.findViewById(R.id.idTVCategory);
            categoryIV=itemView.findViewById(R.id.idIVCategory);
        }
    }
}
