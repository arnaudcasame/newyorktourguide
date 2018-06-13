package com.example.android.newyork;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mBarDrawerToggle;
    private NavigationView mNavigation;

    private ListView list;

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

        ArrayList places = new ArrayList<Place>();
        places.add(new Place(R.drawable.statue_of_liberty, "Statue of Liberty", 4.6, 25757, "Iconic National Monument opened in 1886, offering guided tours, a museum & city views.", "New York, NY 10004", "Gustave Eiffel, Frédéric Auguste Bartholdi, Richard Morris Hunt", "Height: 305′\n" +
                "Construction started: September 1875\n" +
                "Hours: Closed ⋅ Opens 8:30AM Wed\n" +
                "Established: October 15, 1924\n" +
                "Phone: (212) 363-3200", "The Statue of Liberty remains an enduring symbol of freedom and democracy, as well as one of the world's most recognizable landmarks.", "N/A"));

        places.add(new Place(R.drawable.central_park, "Central Park", 4.8, 72745, "Sprawling park with pedestrian paths & ballfields, plus a zoo, carousel, boat rentals & a reservoir.", "New York, NY", "Frederick Law Olmsted (1822–1903), Calvert Vaux (1824–1895)", "Area: 1.317 mi²\n" +
                "Hours: Open ⋅ Closes 1AM\n" +
                "Borough: Manhattan\n" +
                "Phone: (212) 310-6600", "Bow Bridge is one of the most photographed and filmed locations in Central Park and it deserves every bit of its star reputation.", "New York City Department of Parks and Recreation"));

        places.add(new Place(R.drawable.empire_state_building, "Empire State Building", 4.6, 29326, "Iconic, art deco office tower from 1931 with exhibits & observatories on the 86th & 102nd floors.", "350 5th Ave, New York, NY 10118", " William F. Lamb, Yasuo Matsui, Arthur Loomis Harmon, Gregory Johnson", "Height: 1,250′, 1,454′ to tip CTBUH\n" +
                "Floors: 102\n" +
                "Construction started: March 17, 1930\n" +
                "Hours: Open ⋅ Closes 2AM\n" +
                "Phone: (212) 736-3100", "William F. Lamb designed the Empire State Building.", "N/A"));

        places.add(new Place(R.drawable.time_square, "Times Square", 4.6, 55287, "Bustling destination in the heart of the Theater District known for bright lights, shopping & shows.", "Manhattan, NY 10036","N/A", "Hours: Closed ⋅ Opens 9AM Wed\n" +
                "Borough: Manhattan", "The crowds who still gathered in Times Square celebrated with a minute of silence followed by chimes ringing out from an amplifier truck parked at One Times Square.", "N/A"));

        places.add(new Place(R.drawable.rock_center, "Rockefeller Center", 4.6, 42847, "Famous complex that's home to TV studios, plus a seasonal ice rink & giant Christmas tree.", "45 Rockefeller Plaza, New York, NY 10111", "Raymond Hood", "Area: 22 acres\n" +
                "Hours: Open now · \n" +
                "Add full hours\n" +
                "Phone: (212) 332-6868\n" +
                "Borough: Manhattan\n" +
                "Order: trycaviar.com\n" +
                "Added to NRHP: December 23, 1987\n" +
                "Architectural styles: Modern architecture, Art Deco", "Rockefeller Center got its start in 1928, when John D. Rockefeller, Jr., leased the space from Columbia University.", "N/A"));

        places.add(new Place(R.drawable.high_line, "High Line", 4.7, 14902, "Popular park 30 feet above street level on an old rail line, with river & city views.", "New York, NY 10011", "N/A", "Area: 1.448 mi²\n" +
                "Hours: Closed ⋅ Opens 7AM Wed\n" +
                "Date completed: 2014\n" +
                "Borough: Manhattan\n" +
                "Phone: (212) 500-6035\n" +
                "Number of visitors: 5,000,000 (2014)", "The stretch of the High Line near the Gansevoort Street entrance is known as the Gansevoort Woodland. ", "N/A"));

        places.add(new Place(R.drawable.the_metropolitan_museum_of_art, "The Metropolitan Museum of Art", 4.8, 15434, "A grand setting for one of the world's greatest collections of art, from ancient to contemporary.", "1000 5th Ave, New York, NY 10028", "N/A", "Hours: Closed ⋅ Opens 10AM Wed\n" +
                "Director: Max Hollein\n" +
                "Customer service: 1 (800) 662-3397\n" +
                "Subsidiary: The Cloisters", "Forty percent of the Met's visitors in fiscal year 2016 came from New York City and the tristate area; 41 percent from 190 countries besides the United States.", "N/A"));

        places.add(new Place(R.drawable.brooklyn_bridge, "Brooklyn Bridge", 4.7, 15113, "Beloved, circa-1883 landmark connecting Manhattan & Brooklyn via a unique stone-&-steel design.", "Brooklyn Bridge, New York, NY 10038", "John A. Roebling", "Total length: 5,989′\n" +
                "Construction started: January 3, 1870\n" +
                "Body of water: East River\n" +
                "Architect: John A. Roebling\n" +
                "Bridge type: Suspension bridge, Cable-stayed bridge", "When it opened, it was the longest suspension bridge in the world.", "N/A"));

        places.add(new Place(R.drawable.broadway_theatre_district, "Broadway Theatre District", 0.0, 0, "N/A", "New York City", "N/A", "Zip code: 10018, 10019, 10036\n" +
                "Area code: Area code 212\n" +
                "City: New York City\n" +
                "Hotels: Westin New York at Times Square, MORE", "Broadway is a collection of 40 professional theatres (able to hold 500 or more ticket holders each) in New York City, located in Midtown Manhattan, NY's Theatre District and Lincoln Center.", "N/A"));

        places.add(new Place(R.drawable.the_battery, "The Battery", 4.5, 10354, "Historic park with Ellis Island & Statue of Liberty views & ferry service to both islands.", "New York, NY 10004", "N/A", "N/A", "In 1982 New York State designated Battery Park as a part of Harbor Park, a group of historic waterfront sites.", "N/A"));

        places.add(new Place(R.drawable.grand_central_terminal, "Grand Central Terminal", 4.6, 2618, "Iconic train station known for its grand facade & main concourse, also offering shops & dining.", "89 E 42nd St, New York, NY 10017", "John Wellborn Root, Whitney Warren, Alfred T. Fellheimer", "Area: 47 acres\n" +
                "Opened: 1871\n" +
                "Owner: Midtown TDR Ventures\n" +
                "Architectural style: Beaux-Arts architecture\n" +
                "Phone: (212) 340-2583", "A race of tiny aliens is kept inside a Grand Central locker, while at the end of the film, a locker in an enormous alien version of the terminal is shown to contain the human world.", "N/A"));

        places.add(new Place(R.drawable.museum_of_modern_art, "Museum of Modern Art", 4.5, 14415, "Works from van Gogh to Warhol & beyond plus a sculpture garden, 2 cafes & The Modern restaurant.", "11 W 53rd St, New York, NY 10019", "Yoshio Taniguchi, Edward Durell Stone, Philip Goodwin", "Hours: Closed ⋅ Opens 10:30AM\n" +
                "Customer service: 1 (212) 708-9400\n" +
                "Director: Glenn Lowry", "In addition to its renowned permanent collection, MoMa presents special exhibitions (that are often among the hottest tickets in town), and special events.", "N/A"));

        places.add(new Place(R.drawable.national_september_11_memorial_museum, "National September 11 Memorial & Museum", 4.8, 17692, "Plaza, pools & exhibits honoring victims of 1993 & 2001 WTC terrorist attacks. Free timed admission.", "180 Greenwich St, New York, NY 10007", "Michael Arad, Daniel Libeskind, Peter Walker", "Opened: September 11, 2011\n" +
                "Construction started: March 2006\n" +
                "Height: 75′\n" +
                "Hours: Closed ⋅ Opens 9AM\n" +
                "Phone: (212) 312-8800\n" +
                "Function: Museum", "N/A", "N/A"));

        places.add(new Place(R.drawable.one_world_trade_center, "One World Trade Center", 4.7, 7158, "A casual cafe, a bar with small plates & American fine dining with views from the 101st floor.", "285 Fulton St, New York, NY 10007", "Daniel Libeskind, David Childs, T. J. Gottesdiener", "Height: 1,776′, 1,792′ to tip CTBUH\n" +
                "Floors: 104\n" +
                "Construction started: April 27, 2006\n" +
                "Opened: November 3, 2014\n" +
                "Hours: Closed ⋅ Opens 9AM\n" +
                "Phone: (844) 696-1776", "One World Trade Center is the 10th-tallest freestanding structure in the world by pinnacle height (546.2 m).", "N/A"));

        places.add(new Place(R.drawable.liberty_island, "Liberty Island", 4.5, 158, "Liberty Island is a federally owned island in Upper New York Bay in the United States, best known as the location of the Statue of Liberty.","N/A", "N/A", "N/A", "The Statue of Liberty sits on the Liberty Island which is situated in the New York Harbor.", "N/A"));

        PlaceAdapter adapter = new PlaceAdapter(MainActivity.this, places);
        list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
