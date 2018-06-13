package com.example.android.newyork;

/**
 * Created by Arnaud Casamé on 6/12/2018.
 */

public class Place {
    private int picture;
    private String title;
    private double rating;
    private int reviews;
    private String description;
    private String address;
    private String architects;
    private String more;
    private String facts;
    private String owner;

    public Place(int picture, String title, double rating, int reviews, String description, String address, String architects, String more, String facts, String owner){
        this.picture = picture;
        this.title = title;
        this.rating = rating;
        this.reviews = reviews;
        this.description = description;
        this.address = address;
        this.architects = architects;
        this.more = more;
        this.facts = facts;
        this.owner = owner;
    }

    public int getPicture(){
        return picture;
    }

    public String getTitle(){
        return title;
    }

    public double getRating(){
        return rating;
    }

    public int getReviews(){
        return reviews;
    }

    public  String getDescription(){
        return description;
    }

    public String getAddress(){
        return address;
    }

    public String getArchitects(){
        return architects;
    }

    public String getMore(){
        return more;
    }

    public String getFacts(){
        return facts;
    }

    public String getOwner(){
        return owner;
    }
}
