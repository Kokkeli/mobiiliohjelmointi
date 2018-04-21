package com.example.kokkeli.bpappis;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.app.Activity;
import android.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DBContentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DBContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DBContentFragment extends android.support.v4.app.Fragment {
    ListView listView;

    private DatabaseReference mDatabase;

    private OnFragmentInteractionListener mListener;

    public DBContentFragment() {
        // Required empty public constructor
    }

    public static DBContentFragment newInstance() {
        DBContentFragment fragment = new DBContentFragment();
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
        View view = inflater.inflate(R.layout.fragment_db_contents, container, false);
        listView = (ListView)view.findViewById(R.id.content);

        mDatabase.child("books").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        List<Book> books = new ArrayList<Book>();
                        for(DataSnapshot snap : dataSnapshot.getChildren()){
                            Book book = snap.getValue(Book.class);
                            books.add(book);
                        }
                        updateContent(books);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                }
        );
        /*final Cursor cursor = cursorint.getBooksCursor();
        if(cursor != null && cursor.getCount()>0){
            String [] columns = new String[] {
                    DBHelper.BOOK_COLUMN_NAME,
                    DBHelper.BOOK_COLUMN_NUMBER,
                    DBHelper.BOOK_COLUMN_RATING,
                    DBHelper.BOOK_COLUMN_YEAR
            };
            int [] widgets = new int[] {
                    R.id.bookName,
                    R.id.bookNumber,
                    R.id.bookRating,
                    R.id.bookYear
            };

            SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this.getContext(), R.layout.book_info, cursor, columns, widgets, 0);
            listView.setAdapter(cursorAdapter);
        }*/
        return view;
    }

    private void updateContent(List<Book> books){
        if(super.getContext() == null){
            // Activity is not ready and context is not available.
            // Dont update context for now
            // This happens when this view is created again before previous is ready.
            return;
        }
        BookList adapter = new BookList(super.getContext(), R.layout.book_info, books);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}