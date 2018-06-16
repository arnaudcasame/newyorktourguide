package com.example.android.newyork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class PlacesFragment extends Fragment {
    private ListView mList;
    private ArrayList<Place> places;

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        places = new PlacesDataProvider().getPlacesToVisit();

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        mList = (ListView) getView().findViewById(R.id.list_view);
        mList.setAdapter(adapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent go = new Intent(getActivity(), DetailsActivity.class);
                go.putExtra("index", i);
                go.putExtra("fragment", "places");
                startActivity(go);
            }
        });
    }
}
