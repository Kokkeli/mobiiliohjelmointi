package com.example.kokkeli.bpappis;


/**
 * Created by Kokkeli on 09/04/2018.
 */

public class Book {
    private String _name;
    private int _number, _year, _rating;

    public Book(String name, int number, int year, int rating){
        _name = name;
        _number = number;
        _year = year;
        _rating = rating;
    }

    public String get_name(){
        return _name;
    }
    public int get_number(){
        return _number;
    }
    public int get_year(){
        return _year;
    }
    public int get_rating(){
        return _rating;
    }
}
