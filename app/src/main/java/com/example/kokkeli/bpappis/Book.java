package com.example.kokkeli.bpappis;


/**
 * Created by Kokkeli on 09/04/2018.
 */
import com.google.firebase.database.IgnoreExtraProperties;

// [START blog_user_class]
@IgnoreExtraProperties
public class Book {
    public String name;
    public int number, year, rating;

    public Book() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Book(String name, int number, int year, int rating){
        this.name = name;
        this.number = number;
        this.year = year;
        this.rating = rating;
    }

    public String get_name(){
        return name;
    }
    public int get_number(){
        return number;
    }
    public int get_year(){
        return year;
    }
    public int get_rating(){ return rating; }
}
