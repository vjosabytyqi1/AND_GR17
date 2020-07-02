package com.example.projekti.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.example.projekti.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout linearLayout;
    AnimationDrawable animationDrawable;
    Button btnKos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadLocale();



        linearLayout=(ConstraintLayout) findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(4000);

        animationDrawable.start();
        btnKos=(Button) findViewById(R.id.btnKos);

        btnKos.setOnClickListener((v)->{
            Intent intent=new Intent(MainActivity.this, Regjistrimi.class);
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
                shfaqGjuhet();
                return true;
            case R.id.item2:
                Intent intent=new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                Intent intent1=new Intent(this,Regjistrimi.class);
                startActivity(intent1);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void shfaqGjuhet(){

        final String[] gjuhet={"Shqip","English"};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Zgjedheni gjuhen");
        builder.setSingleChoiceItems(gjuhet, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0){
                    setLocal("sq");
                    recreate();
                }
                if (i==1) {
                    setLocal("en");
                    recreate();
                }
                dialogInterface.dismiss();

            }


        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private void setLocal(String lang) {


        Locale locale=new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;

        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();

        editor.putString("Gjuha",lang);
        editor.apply();

    }


    public void loadLocale(){

        SharedPreferences preferences=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language=preferences.getString("Gjuha","");

        setLocal(language);

    }
}
