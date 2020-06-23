package com.example.projekti.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projekti.Adapters.CoffeeAdapter;
import com.example.projekti.Helpers.CoffeeItem;
import com.example.projekti.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private ArrayList<CoffeeItem> coffeeItems = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CoffeeAdapter(coffeeItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        coffeeItems.add(new CoffeeItem(R.drawable.flija, "Fli","0","0"));
        coffeeItems.add(new CoffeeItem(R.drawable.burek, "Pite","1","0"));
        coffeeItems.add(new CoffeeItem(R.drawable.baklava, "Bakllava","2","0"));
        coffeeItems.add(new CoffeeItem(R.drawable.desert, "Tespishte","3","0"));
        coffeeItems.add(new CoffeeItem(R.drawable.qebapa, "Qebapa","4","0"));
        coffeeItems.add(new CoffeeItem(R.drawable.leqenik, "Leqenik","5","0"));
        coffeeItems.add(new CoffeeItem(R.drawable.shampite, "Shampite","6","0"));
        coffeeItems.add(new CoffeeItem(R.drawable.qaj, "Qaj","7","0"));
        coffeeItems.add(new CoffeeItem(R.drawable.vere, "Vere","8","0"));

        return root;
    }
}