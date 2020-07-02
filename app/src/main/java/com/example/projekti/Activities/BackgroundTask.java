package com.example.projekti.Activities;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projekti.Helpers.Helpers.DbOperations;
import com.example.projekti.data.Product;
import com.example.projekti.Adapters.ProductAdapter;
import com.example.projekti.Helpers.Helpers.ProductContract;
import com.example.projekti.R;

public class BackgroundTask extends AsyncTask<String, Product,String> {
    Context ctx;
    ProductAdapter productAdapter;
    Activity activity;
    ListView listView;
    BackgroundTask(Context ctx){
        this.ctx=ctx;
        activity=(Activity)ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method=params[0];
        DbOperations dbOperations=new DbOperations(ctx);
        if(method.equals("add_info")){

            String Name=params[1];
            String data_fillim=params[2];
            String data_mbarim=params[3];
            SQLiteDatabase db=dbOperations.getWritableDatabase();
            dbOperations.addInfomations(db,Name,data_fillim,data_mbarim);
            return "Row inserted...";
        }
        else if (method.equals("get_info")){
            listView=(ListView)activity.findViewById(R.id.display_listview);
            SQLiteDatabase db=dbOperations.getReadableDatabase();
            Cursor cursor=dbOperations.getInformations(db);
            productAdapter=new ProductAdapter(ctx,R.layout.display_product_raw);
            String id,name;
            String data_fillim,data_mbarim;
            while(cursor.moveToNext()){
                name=cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.NAME));
                data_fillim=cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.data_fillim));
                data_mbarim=cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.data_mbarim));
                Product product=new Product(name,data_fillim,data_mbarim);
                publishProgress(product);


            }
            return "get_info";
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Product... values) {
        productAdapter.add(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("get_info")){
            listView.setAdapter(productAdapter);
        }
        else {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }

    }
}
