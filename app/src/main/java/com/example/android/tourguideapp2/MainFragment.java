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

public class MainFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        getActivity().setTitle("General");

        //Assign values within an array list
        ArrayList<ListInfo> info = new ArrayList<ListInfo>();
        info.add(new ListInfo("History", "Learn about Toronto", R.drawable.general));
        info.add(new ListInfo("Population", "The current population of Toronto", R.drawable.general));
        info.add(new ListInfo("Map", "Explore a map of the city", R.drawable.general));

        //Create an object for a custom adapter
        CustomViewAdapter adapter = new CustomViewAdapter(getActivity(), info);

        //Create an object for a list view, and assign the custom adapter to the view
        listView = (ListView) rootView.findViewById(R.id.list_general);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                switch (position) {
                    case 0:
                        Intent historyIntent = new Intent(getContext(), HistoryActivity.class);
                        startActivity(historyIntent);
                        break;
                    case 1:
                        Intent populationIntent = new Intent(getContext(), PopulationActivity.class);
                        startActivity(populationIntent);
                        break;
                    case 2:
                        Intent mapIntent = new Intent(getContext(), MapActivity.class);
                        startActivity(mapIntent);
                        break;
                    default:
                        break;
                }
            }
        });

        return rootView;
    }

}
