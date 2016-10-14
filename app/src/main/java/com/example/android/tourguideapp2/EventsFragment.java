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

public class EventsFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_events, container, false);

        getActivity().setTitle("Events");

        //Assign values within an array list
        ArrayList<ListInfo> info = new ArrayList<ListInfo>();
        info.add(new ListInfo("Toronto Raptors vs. San Lorenzo de Almagro", "Tap for more info", R.drawable.basketball));
        info.add(new ListInfo("Toronto Blue Jays vs. Clevland Browns", "Tap for more info", R.drawable.baseball));

        //Create an object for a custom adapter
        CustomViewAdapter adapter = new CustomViewAdapter(getActivity(), info);

        //Create an object for a list view, and assign the custom adapter to the view
        listView = (ListView) rootView.findViewById(R.id.list_events);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                switch (position) {
                    case 0:
                        Intent basketballIntent = new Intent(getContext(), BasketballActivity.class);
                        startActivity(basketballIntent);
                        break;
                    case 1:
                        Intent baseballIntent = new Intent(getContext(), BaseballActivity.class);
                        startActivity(baseballIntent);
                        break;
                    default:
                        break;
                }
            }
        });

        return rootView;
    }

}



