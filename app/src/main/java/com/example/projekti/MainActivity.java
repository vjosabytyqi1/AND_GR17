package com.example.projekti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Item 1 u selektu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                Intent intent1=new Intent(this,Regjistrimi.class);
                startActivity(intent1);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
