package com.example.kokkeli.bpappis;


/**
 * Created by Kokkeli on 09/04/2018.
 */
import com.google.firebase.database.IgnoreExtraProperties;

// [START blog_user_class]
@IgnoreExtraProperties
public class Result {
    private String team1player1, team1player2, team2player1, team2player2;
    private int winner, cupsleft;

    public Result() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Result(String team1player1, String team1player2, String team2player1, String team2player2, int winner, int cupsleft){
        this.team1player1 = team1player1;
        this.team1player2 = team1player2;
        this.team2player1 = team2player1;
        this.team2player2 = team2player2;
        this.winner = winner;
        this.cupsleft = cupsleft;
    }

    public String get_team1player1(){
        return team1player1;
    }
    public String get_team1player2(){
        return team1player2;
    }
    public String get_team2player1(){
        return team2player1;
    }
    public String get_team2player2(){
        return team2player2;
    }
    public int get_winner(){
        return winner;
    }
    public int get_cupsleft(){
        return cupsleft;
    }
}
