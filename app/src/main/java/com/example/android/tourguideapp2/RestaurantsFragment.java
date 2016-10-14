package com.example.android.tourguideapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_restaurants, container, false);

        getActivity().setTitle("Restaurants");

        //Assign values within an array list
        ArrayList<ListInfo> info = new ArrayList<ListInfo>();
        info.add(new ListInfo(getString(R.string.array_restaurant1), getString(R.string.array_restaurant1_desc), R.drawable.restaurant));
        info.add(new ListInfo(getString(R.string.array_restaurant2), getString(R.string.array_restaurant2_desc), R.drawable.restaurant));

        //Create an object for a custom adapter
        CustomViewAdapter adapter = new CustomViewAdapter(getActivity(), info);

        //Create an object for a list view, and assign the custom adapter to the view
        listView = (ListView) rootView.findViewById(R.id.list_restaurants);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                switch (position) {
                    case 0:
                        Intent firstIntent = new Intent(getContext(), RestaurantActivity1.class);
                        startActivity(firstIntent);
                        break;
                    case 1:
                        Intent secondIntent = new Intent(getContext(), RestaurantActivity2.class);
                        startActivity(secondIntent);
                        break;
                    default:
                        break;
                }
            }
        });
        return rootView;
    }
}



