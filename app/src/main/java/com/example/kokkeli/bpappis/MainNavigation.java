package com.example.kokkeli.bpappis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.*;

public class MainNavigation extends AppCompatActivity
        implements
        DBContentFragment.DBContentInteractionListener,
        AddNewResultFragment.InteractionListener,
        StatsFragment.StatsFragmentInteractionListener
{
    private FragmentTransaction ft;

    private DatabaseReference mDatabase;

    private List<Result> _results;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_stats:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.your_placeholder, StatsFragment.newInstance());
                    ft.commit();
                    return true;
                case R.id.navigation_games:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.your_placeholder, DBContentFragment.newInstance());
                    ft.commit();
                    return true;
                case R.id.navigation_add:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.your_placeholder, AddNewResultFragment.newInstance());
                    ft.commit();
                    return true;
                case R.id.navigation_logout:
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        _results = new ArrayList<Result>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // Set listener for results
        mDatabase.child("results").addValueEventListener(
            new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    _results = new ArrayList<Result>();
                    for(DataSnapshot snap : dataSnapshot.getChildren()){
                        Result result = snap.getValue(Result.class);
                        _results.add(result);
                    }
                    // Todo: call to update all fragments?
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            }
        );

        // Begin the transaction
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, new DBContentFragment());
        ft.commit();
    }

    @Override
    public void onAddResult(Result res){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference resref = ref.child("results");
        resref.push().setValue(res);
    }
/*
    @Override
    public void onDBDeleteBook(Integer book_number){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query queryRef = ref.child("books").orderByChild("number").equalTo(book_number);
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    snapshot.getRef().removeValue();
                }
            }
            @Override
            public void onCancelled(DatabaseError err){
                System.out.println("The read failed: " + err.getCode());
            }
        });
    }*/

    @Override
    public List<Result>getAllResults(){
        return _results;
    }

    @Override
    public List<Result>getResultsForName(String uname){
        List<Result> response = new ArrayList<Result>();
        for(Result res : _results){
            if(res.winner1.equals(uname) || res.winner2.equals(uname) || res.loser1.equals(uname) || res.loser2.equals(uname)){
                response.add(res);
            }
        }
        return response;
    }
}
