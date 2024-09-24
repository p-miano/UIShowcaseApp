package com.example.uishowcaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.widget.SwitchCompat; // Import SwitchCompat
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConstraintLayoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_constraint_layout, container, false);

        // Find UI components
        SwitchCompat switchToggle = view.findViewById(R.id.switch_toggle);
        ProgressBar progressBar = view.findViewById(R.id.progress_bar);
        FloatingActionButton fabShowSnackbar = view.findViewById(R.id.fab_show_snackbar);

        // Set "On" and "Off" labels programmatically
        switchToggle.setTextOn(getString(R.string.switch_on));
        switchToggle.setTextOff(getString(R.string.switch_off));
        switchToggle.setShowText(true);

        // Set listener for the switch
        switchToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        // Set listener for the FAB to show a Snackbar
        fabShowSnackbar.setOnClickListener(v -> {
            Snackbar.make(v, getString(R.string.snackbar_message), Snackbar.LENGTH_LONG).show();
        });

        return view;
    }
}
