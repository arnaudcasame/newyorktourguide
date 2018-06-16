package com.example.android.newyork;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tablayout = (TabLayout) findViewById(R.id.tablayout_id);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        FixedPagerAdapter adapter = new FixedPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Details1Fragment(), "Informations");
        adapter.addFragment(new Details2Fragment(), "Directions");
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index", -1);
        String frag = intent.getStringExtra("fragment");

        ArrayList places;

        if(TextUtils.equals("places", frag)){
           places = new PlacesDataProvider().getPlacesToVisit();
        }else{
           places = new PlacesDataProvider().getAccommodations();
        }

        Place place = (Place) places.get(index);

        ImageView picture = (ImageView) findViewById(R.id.image_view);
        picture.setImageResource(place.getPicture());

        TextView reviews = (TextView) findViewById(R.id.review);
        reviews.setText(place.getReviews()+" Reviews");

        TextView title = (TextView) findViewById(R.id.card_title);
        title.setText(place.getTitle());

        TextView rating = (TextView) findViewById(R.id.rating_text);
        rating.setText(String.valueOf(place.getRating()));

        RatingBar stars = (RatingBar) findViewById(R.id.rating_bar);
        stars.setRating((float) place.getRating());

    }
}
