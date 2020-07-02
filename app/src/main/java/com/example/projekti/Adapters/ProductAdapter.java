package com.example.projekti.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projekti.R;
import com.example.projekti.data.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public ProductAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Product object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        ProductHolder productHolder;
        if (row==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.display_product_raw,parent,false);
            productHolder = new ProductHolder();

            productHolder.tx_name=(TextView)row.findViewById(R.id.t_name);
            productHolder.tx_data_fillim=(TextView)row.findViewById(R.id.t_data_fillim);
            productHolder.tx_data_mbarim=(TextView)row.findViewById(R.id.t_data_mbarim);
            row.setTag(productHolder);
        }
        else {
            productHolder=(ProductHolder)row.getTag();
        }
        Product product=(Product)getItem(position);

        productHolder.tx_name.setText(product.getName().toString());
        productHolder.tx_data_fillim.setText(product.getdata_fillim().toString());
        productHolder.tx_data_mbarim.setText(product.getdata_mbarim().toString());


        return row;
    }
    static class ProductHolder{
        TextView tx_name,tx_data_fillim,tx_data_mbarim;
    }
}
