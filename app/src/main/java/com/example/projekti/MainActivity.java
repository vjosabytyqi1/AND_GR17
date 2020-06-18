package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout linearLayout;
    AnimationDrawable animationDrawable;
    Button btnKos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        linearLayout=(ConstraintLayout) findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(4000);

        animationDrawable.start();
        btnKos=(Button) findViewById(R.id.btnKos);

        btnKos.setOnClickListener((v)->{
            Intent intent=new Intent(MainActivity.this,Regjistrimi.class);
            startActivity(intent);
            animationDrawable.stop();
        });
    }

}
