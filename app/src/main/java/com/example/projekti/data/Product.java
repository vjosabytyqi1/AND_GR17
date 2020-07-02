package com.example.projekti.data;

public class Product {
    private String name;
    private String data_fillim,data_mbarim;

    public Product( String name,String data_fillim,String data_mbarim){
        this.setName(name);
        this.setdata_fillim(data_fillim);
        this.setdata_mbarim(data_mbarim);


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdata_fillim() {
        return data_fillim;
    }

    public void setdata_fillim(String data_fillim) {
        this.data_fillim = data_fillim;
    }

    public String getdata_mbarim() {
        return data_mbarim;
    }

    public void setdata_mbarim(String data_mbarim) {
        this.data_mbarim = data_mbarim;
    }
}
