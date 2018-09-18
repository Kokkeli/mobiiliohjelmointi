package com.example.kokkeli.bpappis;


/**
 * Created by Kokkeli on 09/04/2018.
 */
import com.google.firebase.database.IgnoreExtraProperties;

// [START blog_user_class]
@IgnoreExtraProperties
public class Result {
    public String winner1, winner2, loser1, loser2;
    public int cupsleft;

    public Result() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Result(String winner1, String winner2, String loser1, String loser2, int cupsleft){
        this.winner1 = winner1;
        this.winner2 = winner2;
        this.loser1 = loser1;
        this.loser2 = loser2;
        this.cupsleft = cupsleft;
    }

    public String get_winner1(){
        return winner1;
    }
    public String get_winner2(){
        return winner2;
    }
    public String get_loser1(){
        return loser1;
    }
    public String get_loser2(){
        return loser2;
    }
    public int get_cupsleft(){
        return cupsleft;
    }
}
