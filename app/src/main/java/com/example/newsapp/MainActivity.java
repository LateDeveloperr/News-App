package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    //9ece233a093040b0bad079f76cb01b3c

    private RecyclerView newsRV,IVcategor;
    private ProgressBar PBloading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRV=findViewById(R.id.idIVNews);
        IVcategor=findViewById(R.id.idIVCategory);
        PBloading=findViewById(R.id.idPBLoading);


    }
}