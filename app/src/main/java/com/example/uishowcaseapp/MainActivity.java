package com.example.uishowcaseapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.uishowcaseapp.GridLayoutFragment;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set default fragment when app starts
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LinearLayoutFragment()).commit();
        }

        // Handle navigation item clicks
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.page1) {
                    selectedFragment = new LinearLayoutFragment();
                } else if (item.getItemId() == R.id.page2) {
                    selectedFragment = new ConstraintLayoutFragment();
                } else if (item.getItemId() == R.id.page3) {
                    selectedFragment = new GridLayoutFragment();
                } else if (item.getItemId() == R.id.page4) {
                    selectedFragment = new ListLayoutFragment();
                }

                // Replace the fragment in the container
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}