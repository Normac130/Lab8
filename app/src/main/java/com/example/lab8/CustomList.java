package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){

        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This returns true if city is in list, and false if it doesn't
     * @param city city to be found
     * @return True if list has city, else false
     */
    public boolean hasCity(City city) {

        return cities.contains(city);
    }

    /**
     * deletes specified city from the list
     * @param city city to be deleted
     */
    public void delete(City city) {
        if (!(cities.contains(city))) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    public int countCities() {
        return cities.size();
    }


}
