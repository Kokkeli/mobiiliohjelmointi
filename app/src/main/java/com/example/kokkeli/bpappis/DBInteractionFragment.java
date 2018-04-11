package com.example.kokkeli.bpappis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DBInteractionFragment.OnDBInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DBInteractionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DBInteractionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnDBInteractionListener mListener;

    private EditText _name;
    private EditText _number;
    private EditText _year;
    private EditText _rating;
    private Button _save;

    public DBInteractionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DBInteractionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DBInteractionFragment newInstance() {
        DBInteractionFragment fragment = new DBInteractionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dbinteraction, container, false);
        _name = (EditText)view.findViewById(R.id.bookName);
        _number = (EditText)view.findViewById(R.id.bookNumber);
        _rating = (EditText)view.findViewById(R.id.bookRating);
        _year = (EditText)view.findViewById(R.id.bookYear);
        _save = (Button)view.findViewById(R.id.save);
        _save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_name.getText().toString().equals("")){
                    return;
                }
                if(_number.getText().toString().equals("")){
                    return;
                }
                if(_year.getText().toString().equals("")){
                    return;
                }
                if(_rating.getText().toString().equals("")){
                    return;
                }
                Book book = new Book(
                        _name.getText().toString(),
                        Integer.valueOf(_number.getText().toString()),
                        Integer.valueOf(_year.getText().toString()),
                        Integer.valueOf(_rating.getText().toString())
                );
                mListener.onDBAddBook(book);
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDBInteractionListener) {
            mListener = (OnDBInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
    public interface OnDBInteractionListener {
        // TODO: Update argument type and name
        void onDBAddBook(Book book);
    }


}
