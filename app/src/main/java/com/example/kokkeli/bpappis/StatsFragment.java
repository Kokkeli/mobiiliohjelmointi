package com.example.kokkeli.bpappis;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;
import android.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.io.Console;
import java.util.*;

public class StatsFragment extends android.support.v4.app.Fragment {

    private DatabaseReference mDatabase;

    private StatsFragmentInteractionListener mListener;

    TextView _playerName;
    TextView _wins;
    TextView _games;
    EditText _searchInput;

    Button _search;

    public StatsFragment() {
        // Required empty public constructor
    }

    public static StatsFragment newInstance() {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats_layout, container, false);
        _playerName = (TextView) view.findViewById(R.id.playerName);
        _wins = (TextView) view.findViewById(R.id.wins);
        _games = (TextView) view.findViewById(R.id.games);
        _searchInput = (EditText) view.findViewById(R.id.searchName);
        _search = (Button)view.findViewById(R.id.search);
        _search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStatsForUser(_searchInput.getText().toString());
            }
        });
        return view;
    }

    private void showStatsForUser(String uname){
        List<Result> results = mListener.getResultsForName(uname);
        int wins = 0;
        for(Result res : results){
            if(res.winner2.equals(uname) || res.winner1.equals(uname)){
                wins = wins+1;
            }
        }
        _wins.setText(Integer.toString(wins));
        _games.setText(Integer.toString(results.size()));
        _playerName.setText(uname);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof StatsFragmentInteractionListener) {
            mListener = (StatsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface StatsFragmentInteractionListener {
        List<Result> getResultsForName(String uname);
    }
}
