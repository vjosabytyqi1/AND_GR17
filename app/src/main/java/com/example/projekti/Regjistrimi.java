package com.example.projekti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Regjistrimi extends AppCompatActivity implements View.OnClickListener {
   private Button btnRegister;
   private EditText editEmail,editPassword;
   private TextView textViewRegjister;
   private ProgressDialog progressDialog;
   private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regjistrimi);

        firebaseAuth=FirebaseAuth.getInstance();

        progressDialog=new ProgressDialog(this);

        btnRegister=findViewById(R.id.btnregister);

        editEmail=findViewById(R.id.editEmail);

        editPassword=findViewById(R.id.editPassword);

        textViewRegjister=findViewById(R.id.textViewRegjister);

        btnRegister.setOnClickListener(this);

        textViewRegjister.setOnClickListener(this);




    }
    private void RegisterUser(){
        String email=editEmail.getText().toString().trim();
        String pass=editPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Shkruani email-in",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Shkruani Passwordin",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Regjistimi ne proces...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Regjistrimi.this,"Regjistruar me sukses",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Regjistrimi.this,"Nuk u regjistrua!Provoni perseri!",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    @Override
    public void onClick(View v) {
        if (v==btnRegister){
            RegisterUser();

        }
        if (v==textViewRegjister){
            Intent intent=new Intent(Regjistrimi.this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
