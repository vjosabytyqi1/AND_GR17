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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button btnLogin;
    private EditText etEmail;
    private EditText etPass;
    private TextView textView;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),ProfilActivity.class));
        }


        btnLogin=findViewById(R.id.btnLogin);
        etEmail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPassword);



        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (v==btnLogin){
            userLogin();
        }
    }
    private void userLogin(){
        String email=etEmail.getText().toString().trim();
        String pass=etPass.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Shkruani email-in",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Shkruani Passwordin",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Logini ne proces...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                        finish();
                    Intent intent=new Intent(LoginActivity.this,ProfilActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(LoginActivity.this,"Nuk u regjistrua!Provoni perseri!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
