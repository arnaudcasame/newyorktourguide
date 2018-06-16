package com.example.android.newyork;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mBarDrawerToggle;
    private NavigationView mNavigation;

    private PlacesFragment places;
    private AccommodationsFragment accommodations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        places = new PlacesFragment();
        accommodations = new AccommodationsFragment();

        // Displays the places to visit on start
        replaceFragment(places);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mBarDrawerToggle);
        mBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigation = (NavigationView) findViewById(R.id.navigation_view);
        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int navId = item.getItemId();
                switch (navId){
                    case R.id.places:
                        Toast.makeText(MainActivity.this, "Launches Places to visit fragment", Toast.LENGTH_SHORT).show();
                        replaceFragment(places);
                        setTitle("Places to visit");
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.eats:
                        Toast.makeText(MainActivity.this, "Launches Foods & Drinks fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.accommodations:
                        Toast.makeText(MainActivity.this, "Launches accommodations fragment", Toast.LENGTH_SHORT).show();
                        replaceFragment(accommodations);
                        setTitle("Accommodations");
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.businesses:
                        Toast.makeText(MainActivity.this, "Launches Businesses fragment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.services:
                        Toast.makeText(MainActivity.this, "Launches Services fragment", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void replaceFragment(android.support.v4.app.Fragment fragment){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.commit();
    }

}
