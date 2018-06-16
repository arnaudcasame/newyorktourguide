package com.example.android.newyork;


import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Details2Fragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private double lat;
    private double lon;
    private Place place;

    public Details2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton btn = getActivity().findViewById(R.id.floating_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String map = "http://maps.google.co.in/maps?q=" + place.getAddress();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Intent go = getActivity().getIntent();
        int index = go.getIntExtra("index", -1);
        String frag = go.getStringExtra("fragment");

        ArrayList places;

        if(TextUtils.equals("places", frag)){
            places = new PlacesDataProvider().getPlacesToVisit();
        }else{
            places = new PlacesDataProvider().getAccommodations();
        }

        place = (Place) places.get(index);

        Geocoder location = new Geocoder(getContext());
        try {
            List<Address> address = location.getFromLocationName(place.getAddress(), 1);
            Address add = address.get(0);
            lat = add.getLatitude();
            lon = add.getLongitude();
            LatLng latAndLong = new LatLng(lat, lon);
            mMap.addMarker(new MarkerOptions().position(latAndLong).title(place.getTitle()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latAndLong));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(5.0f));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
