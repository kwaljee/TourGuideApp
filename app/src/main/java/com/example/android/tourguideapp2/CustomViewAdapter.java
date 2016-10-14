package com.example.android.tourguideapp2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomViewAdapter extends ArrayAdapter<ListInfo>{

    public CustomViewAdapter(Activity context, ArrayList<ListInfo> info) {
        super(context, 0, info);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ListInfo currentInfo = getItem(position);

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentInfo.getImageResourceId());

        TextView subtitleView = (TextView) listItemView.findViewById(R.id.subtitle);
        subtitleView.setText(currentInfo.getSubtitle());

        TextView descTextView = (TextView) listItemView.findViewById(R.id.description);
        descTextView.setText(currentInfo.getDescription());

        return listItemView;
    }
}