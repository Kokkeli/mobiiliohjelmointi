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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DBContentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DBContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DBContentFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    CursorInterface cursorint;

    ListView listView;

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public DBContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DBContentFragment.
     */
    // TODO: Rename and change types and number of parameters
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_db_contents, container, false);
        listView = (ListView)view.findViewById(R.id.content);
        final Cursor cursor = cursorint.getBooksCursor();
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
        }
        return view;
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
        cursorint = (CursorInterface) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        cursorint = null;
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

    public interface CursorInterface {
        Cursor getBooksCursor();
    }

}
