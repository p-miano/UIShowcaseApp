package com.example.uishowcaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListLayoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_layout, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        // Load the city names from strings.xml
        String[] cities = getResources().getStringArray(R.array.city_names);

        // Set up the RecyclerView with a custom adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CityAdapter cityAdapter = new CityAdapter(getActivity(), cities);
        recyclerView.setAdapter(cityAdapter);

        return view;
    }
}
