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

public class AttractionsFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_attractions, container, false);

        getActivity().setTitle("Attractions");

        //Assign values within an array list
        ArrayList<ListInfo> info = new ArrayList<ListInfo>();
        info.add(new ListInfo("CN Tower", "Iconic tower with revolving restaurant", R.drawable.attractions));
        info.add(new ListInfo("Royal Ontario Museum", "Huge range of culture and nature exhibits", R.drawable.attractions));
        info.add(new ListInfo("Ontario Science Centre", "Kid friendly museum with hands-on exhibits", R.drawable.attractions));

        //Create an object for a custom adapter
        CustomViewAdapter adapter = new CustomViewAdapter(getActivity(), info);

        //Create an object for a list view, and assign the custom adapter to the view
        listView = (ListView) rootView.findViewById(R.id.list_attractions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                switch (position) {
                    case 0:
                        Intent towerIntent = new Intent(getContext(), TowerActivity.class);
                        startActivity(towerIntent);
                        break;
                    case 1:
                        Intent museumIntent = new Intent(getContext(), MuseumActivity.class);
                        startActivity(museumIntent);
                        break;
                    case 2:
                        Intent scienceIntent = new Intent(getContext(), ScienceActivity.class);
                        startActivity(scienceIntent);
                        break;
                    default:
                        break;
                }
            }
        });


        return rootView;
    }
}