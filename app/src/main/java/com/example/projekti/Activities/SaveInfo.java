package com.example.projekti.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekti.R;

public class SaveInfo extends AppCompatActivity {
    EditText e_name,e_data_fillim,e_data_mbarim,editText;
    String name,data_fillim,data_mbarim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_info);

        e_name=(EditText)findViewById(R.id.d_name);
        e_data_fillim=(EditText)findViewById(R.id.d_data_fillim);
        e_data_mbarim=(EditText)findViewById(R.id.d_data_mbarim);





    }
    public void saveData(View view){
    name=e_name.getText().toString();
    data_fillim=e_data_fillim.getText().toString();
    data_mbarim=e_data_mbarim.getText().toString();

        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("add_info",name,data_fillim,data_mbarim);
        finish();
    }
}
