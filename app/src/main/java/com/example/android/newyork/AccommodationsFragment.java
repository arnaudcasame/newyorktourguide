package com.example.android.newyork;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccommodationsFragment extends Fragment {
    private ListView mList;
    private ArrayList<Place> accommodations;

    public AccommodationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accommodations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        accommodations = new PlacesDataProvider().getAccommodations();

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), accommodations);
        mList = (ListView) getView().findViewById(R.id.list_view);
        mList.setAdapter(adapter);
    }

}
