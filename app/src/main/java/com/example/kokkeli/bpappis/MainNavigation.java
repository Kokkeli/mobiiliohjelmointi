package com.example.kokkeli.bpappis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.database.Cursor;
import android.support.v4.app.FragmentTransaction;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.net.Uri;


public class MainNavigation extends AppCompatActivity
        implements
        DBContentFragment.OnFragmentInteractionListener,
        DBInteractionFragment.OnDBInteractionListener,
        DBContentFragment.CursorInterface
{

    private FragmentTransaction ft;
    DBHelper dbhelper;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.your_placeholder, DBContentFragment.newInstance());
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.your_placeholder, new DBInteractionFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        dbhelper = new DBHelper(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Begin the transaction
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, new DBContentFragment());
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        return;
    }

    @Override
    public void onDBInteraction(Uri uri){
        return;
    }

    @Override
    public Cursor getBooksCursor(){
        return dbhelper.getAllBooks();
    }



}
