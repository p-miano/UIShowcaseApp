package com.example.uishowcaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LinearLayoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_linear_layout, container, false);

        // Find the EditText and Button in the inflated layout
        EditText editTextName = view.findViewById(R.id.editTextName);
        Button buttonShowToast = view.findViewById(R.id.buttonShowToast);

        // Set a click listener on the button
        buttonShowToast.setOnClickListener(v -> {
            // Get the text entered in the EditText
            String name = editTextName.getText().toString();

            // Show a Toast with the entered name
            if (!name.isEmpty()) {
                Toast.makeText(getContext(), "Hello, " + name, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
