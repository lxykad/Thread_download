package com.lxy.thread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    private ExecutorService mSingleThreadExecutor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        mSingleThreadExecutor = Executors.newSingleThreadExecutor();


    }


    public void goProgress(View view) {

        startActivity(new Intent(MainActivity.this, ProgressActivity.class));
    }
}

