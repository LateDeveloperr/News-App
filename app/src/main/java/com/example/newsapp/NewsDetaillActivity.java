package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NewsDetaillActivity extends AppCompatActivity {

    String title , description , content , imageurl , url ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detaill);
        title=getIntent().getStringExtra("title");
        description=getIntent().getStringExtra("description");
        content=getIntent().getStringExtra("content");
        imageurl=getIntent().getStringExtra("imageurl");
        url=getIntent().getStringExtra("url");
    }
}