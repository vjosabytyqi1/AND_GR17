package com.example.projekti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projekti.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void addProduct(View view){
        startActivity(new Intent(this, SaveInfo.class));
    }
    public void displayProducts(View view){
        startActivity(new Intent(this, DisplayProduct.class));
    }
}
