package com.example.projekti;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projekti.Activities.UshqimetAktivitet;
import com.google.firebase.auth.FirebaseAuth;

public class aktivitetetKryesore extends AppCompatActivity  {
    TextView vendet,ushqimet,kultura,harta,valutat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktivitetet_kryesore);

        vendet=findViewById(R.id.vendet);


        vendet.setOnClickListener((v)->{
            Intent intent=new Intent(this, ProfilActivity.class);
            startActivity(intent);
        });
        ushqimet=findViewById(R.id.ushqim);

        ushqimet.setOnClickListener((v -> {
            Intent intent=new Intent(this, UshqimetAktivitet.class);
            startActivity(intent);
        }));

        kultura=findViewById(R.id.kultura);
        kultura.setOnClickListener((v)->{
        startActivity(new Intent(aktivitetetKryesore.this, AktivitetiFoto.class));

        });

        valutat=findViewById(R.id.valutat);
        valutat.setOnClickListener((v)->{
            Intent intent=new Intent(this, AddCurrency.class);
            startActivity(intent);
        });










    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemLogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);

    }







}
