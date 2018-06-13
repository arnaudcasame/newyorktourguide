package com.example.android.newyork;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.newyork.Place;
import com.example.android.newyork.R;

import java.util.ArrayList;

/**
 * Created by Arnaud Casamé on 6/12/2018.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Activity context, ArrayList<Place> places){
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.card_title);
        title.setText(currentPlace.getTitle());

        TextView ratingText = (TextView) listItemView.findViewById(R.id.rating_text);
        ratingText.setText(String.valueOf(currentPlace.getRating()));

        ImageView picture = (ImageView) listItemView.findViewById(R.id.image_view);
        picture.setImageResource(currentPlace.getPicture());

        RatingBar ratingBar = (RatingBar) listItemView.findViewById(R.id.ratingBar);
        float rate = (float) currentPlace.getRating();
        ratingBar.setRating(rate);

        return listItemView;
    }
}
