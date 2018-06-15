package com.example.android.newyork;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Details1Fragment extends Fragment {


    public Details1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Intent go = getActivity().getIntent();
        int index = go.getIntExtra("index", -1);
        String frag = go.getStringExtra("fragment");

        ArrayList places;

        if(TextUtils.equals("places", frag)){
            places = new PlacesDataProvider().getPlacesToVisit();
        }else{
            places = new PlacesDataProvider().getAccommodations();
        }

        Place place = (Place) places.get(index);

        TextView more = (TextView) getActivity().findViewById(R.id.more);
        more.setText(place.getMore());

        TextView desc = (TextView) getActivity().findViewById(R.id.description);
        if(!TextUtils.equals("N/A", place.getDescription())){
            desc.setText(place.getDescription()+" -Google");
        }else{
            desc.setVisibility(View.GONE);
        }

        TextView architects = (TextView) getActivity().findViewById(R.id.architects);
        if(!TextUtils.equals("N/A", place.getArchitects())){
            architects.setText("Architects: "+place.getArchitects());
        }else{
            architects.setVisibility(View.GONE);
        }

        TextView price = (TextView) getActivity().findViewById(R.id.price);
        if(place.getPrice() == 0.0){
            price.setText("Price: Free");
        }else{
            price.setText("Price: $"+place.getPrice());
        }

        TextView owner = (TextView) getActivity().findViewById(R.id.owner);
        if(!TextUtils.equals("N/A", place.getOwner())){
            owner.setText("Owner: "+place.getOwner());
        }else{
            owner.setVisibility(View.GONE);
        }

        CardView dyk_holder = (CardView) getActivity().findViewById(R.id.dyk_holder);
        TextView dyk = (TextView) getActivity().findViewById(R.id.dyk);
        if(!TextUtils.equals("N/A", place.getFacts())){
            dyk.setText(place.getFacts());
        }else{
            dyk_holder.setVisibility(View.GONE);
        }



//        Toast.makeText(getActivity(), index+" est l'index", Toast.LENGTH_SHORT).show();
    }
}
