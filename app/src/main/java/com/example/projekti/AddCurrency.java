package com.example.projekti;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

public class AddCurrency extends AppCompatActivity {
    private RequestQueue queue;
    private TextView txtSearch;
    private EditText numberSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcurrency);
        queue = Volley.newRequestQueue(this);
        txtSearch = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.btnCurr);
        numberSearch = findViewById(R.id.text_input);
        txtSearch.append("Konvertimi i EUR ne valuta tjera: \n");

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

    }

    public static final String TAG = "MyTag";


    private void jsonParse() {

        final String BASE = "&base=EUR";
        final String URL_PREFIX = "https://api.exchangeratesapi.io/latest";

        String url = URL_PREFIX;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            double number = Double.parseDouble(numberSearch.getText().toString());
                            JSONObject list = response.getJSONObject("rates");
                            String base = response.getString("base");
                            Double USD = Double.parseDouble(list.getString("USD"));
                            Double CHF = Double.parseDouble(list.getString("CHF"));
                            Double GBP = Double.parseDouble(list.getString("GBP"));
                            Double CZK = Double.parseDouble(list.getString("CZK"));
                            Double KRW = Double.parseDouble(list.getString("KRW"));
                            Double MYR = Double.parseDouble(list.getString("MYR"));
                            Double SGD = Double.parseDouble(list.getString("SGD"));
                            txtSearch.setText("");
                            txtSearch.append("Konvertimi i EUR ne valuta tjera: \n" + "USD:  " + USD * number + "\n"
                                    + "CHF:  " + CHF * number + "\n"
                                    + "GBP:  " + GBP * number + "\n"
                                    + "CZK:  " + CZK * number + "\n"
                                    + "KRW:  " + KRW * number + "\n"
                                    + "MYR:  " + MYR * number + "\n"
                                    + "SGD:  " + SGD * number + "\n"
                            );


                        } catch (JSONException e) {
                            Snackbar.make(getWindow().getDecorView().getRootView(),e.getMessage(),Snackbar.LENGTH_LONG).setAction("Action",null).show();
                        }
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Snackbar.make(getWindow().getDecorView().getRootView(),"No Response :(",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                    }
                });
        queue.cancelAll(TAG);
        request.setTag(TAG);
        queue.add(request);
    }

}