package com.example.kokkeli.bpappis;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;

import java.util.HashSet;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddNewResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNewResultFragment extends Fragment {

    private InteractionListener mListener;

    private Spinner _cupsleft;

    private EditText _winner1;
    private EditText _winner2;
    private EditText _loser1;
    private EditText _loser2;

    private Button _save;

    public AddNewResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddNewResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddNewResultFragment newInstance() {
        AddNewResultFragment fragment = new AddNewResultFragment();
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
        View view = inflater.inflate(R.layout.fragment_addresult, container, false);

        _cupsleft = (Spinner)view.findViewById(R.id.cups);
        ArrayAdapter<CharSequence> _cupsadapter = ArrayAdapter.createFromResource(
                this.getContext(), R.array.cups_array, R.layout.spinner_layout);
        _cupsleft.setAdapter(_cupsadapter);

        _winner1 = (EditText)view.findViewById(R.id.team1player1);
        _winner2 = (EditText)view.findViewById(R.id.team1player2);
        _loser1 = (EditText)view.findViewById(R.id.team2player1);
        _loser2 = (EditText)view.findViewById(R.id.team2player2);

        _save = (Button)view.findViewById(R.id.save);
        _save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String win1 = _winner1.getText().toString();
                String win2 = _winner2.getText().toString();
                String los1 = _loser1.getText().toString();
                String los2 = _loser2.getText().toString();
                // TODO error notifications
                if(win1.equals("")){
                    return;
                }
                if(win2.equals("")){
                    return;
                }
                if(los1.equals("")){
                    return;
                }
                if(los2.equals("")){
                    return;
                }
                HashSet<String> test = new HashSet<>();
                // If adding to hash set returns false -> object was there already
                // This way we can check that all of the inputted names are unique
                if(!test.add(win1)){
                    return;
                }
                if(!test.add(win2)){
                    return;
                }
                if(!test.add(los1)){
                    return;
                }
                if(!test.add(los2)){
                    return;
                }

                Result res = new Result(_winner1.getText().toString(),
                        _winner2.getText().toString(),
                        _loser1.getText().toString(),
                        _loser2.getText().toString(),
                        Integer.parseInt(_cupsleft.getSelectedItem().toString()));

                mListener.onAddResult(res);
                // TODO check if all usernames are present in the database, if not -> confirm push from user
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteractionListener) {
            mListener = (InteractionListener) context;
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

    public interface InteractionListener {
        void onAddResult(Result r);
    }


}
