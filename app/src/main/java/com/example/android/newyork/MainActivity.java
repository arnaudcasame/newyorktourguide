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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        Toast.makeText(MainActivity.this, "Launches Places activity", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.eats:
                        Toast.makeText(MainActivity.this, "Launches Foods activity", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.accommodations:
                        Toast.makeText(MainActivity.this, "Launches accommodations activity", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.businesses:
                        Toast.makeText(MainActivity.this, "Launches Businesses activity", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.services:
                        Toast.makeText(MainActivity.this, "Launches Services activity", Toast.LENGTH_SHORT).show();
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

}
