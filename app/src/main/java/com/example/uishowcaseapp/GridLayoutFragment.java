package com.example.uishowcaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GridLayoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_layout, container, false);

        // Get the GridView from the layout
        GridView gridView = view.findViewById(R.id.grid_view);

        // Load item names from string resources
        String[] itemNames = {
                getString(R.string.item_1_house),
                getString(R.string.item_2_chalet),
                getString(R.string.item_3_cottage),
                getString(R.string.item_4_houseboat),
                getString(R.string.item_5_hotel),
                getString(R.string.item_6_airbnb)
        };

        // Sample image resources for the grid items
        int[] itemImages = {
                R.drawable.ic_item1_house,
                R.drawable.ic_item2_chalet,
                R.drawable.ic_item3_cottage,
                R.drawable.ic_item4_houseboat,
                R.drawable.ic_item5_hotel,
                R.drawable.ic_item6_airbnb
        };

        // Set the custom adapter to the GridView
        GridAdapter gridAdapter = new GridAdapter(getActivity(), itemNames, itemImages);
        gridView.setAdapter(gridAdapter);

        // Handle item click events
        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            String itemName = itemNames[position];
            String toastMessage = getString(R.string.grid_toast_message, itemName);
            Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
