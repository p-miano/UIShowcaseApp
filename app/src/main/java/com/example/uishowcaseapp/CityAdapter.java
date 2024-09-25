package com.example.uishowcaseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SwitchCompat;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private String[] cities;
    private Context context;

    public CityAdapter(Context context, String[] cities) {
        this.context = context;
        this.cities = cities;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        String city = cities[position];
        holder.cityName.setText(city);

        // Handle switch toggle and display status in a Toast
        holder.statusSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String status = isChecked ? "Active" : "Inactive";
            String toastMessage = context.getString(R.string.status_message, city, status);
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return cities.length;
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        TextView cityName;
        SwitchCompat statusSwitch; // SwitchCompat instead of Switch

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.city_name);
            statusSwitch = itemView.findViewById(R.id.status_switch); // SwitchCompat reference
        }
    }

}
