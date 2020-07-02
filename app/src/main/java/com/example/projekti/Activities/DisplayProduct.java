package com.example.projekti.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekti.R;

public class DisplayProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_product_layout);
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("get_info");

    }
}
