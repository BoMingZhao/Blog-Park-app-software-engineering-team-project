package com.example.my_test6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class browse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        getSupportActionBar().hide();
    }
}
