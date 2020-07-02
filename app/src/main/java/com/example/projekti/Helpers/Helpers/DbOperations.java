package com.example.projekti.Helpers.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbOperations extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="pruduct_info1.db";
    private static final String CREATE_QUERY="create table "+ ProductContract.ProductEntry.TABLE_NAME+
            "("+" text,"+ProductContract.ProductEntry.NAME+" text,"+
            ProductContract.ProductEntry.data_fillim+" integer,"+ProductContract.ProductEntry.data_mbarim+" integer);";
    public DbOperations(Context ctx){
        super(ctx,DB_NAME,null,DB_VERSION);
        Log.d("Database operations","Database created...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations","Table created...");

    }

    public void addInfomations(SQLiteDatabase db,  String name, String data_fillim, String data_mbarim){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ProductContract.ProductEntry.NAME,name);
        contentValues.put(ProductContract.ProductEntry.data_fillim,data_fillim);
        contentValues.put(ProductContract.ProductEntry.data_mbarim,data_mbarim);
        db.insert(ProductContract.ProductEntry.TABLE_NAME,null,contentValues);
        Log.d("Database operations","Row inserted...");


    }
    public Cursor getInformations(SQLiteDatabase db){
        String[] projections={ProductContract.ProductEntry.NAME, ProductContract.ProductEntry.data_fillim, ProductContract.ProductEntry.data_mbarim};
        Cursor cursor=db.query(ProductContract.ProductEntry.TABLE_NAME, projections,null,null,null,null,null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
