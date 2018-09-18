package com.example.kokkeli.bpappis;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ResultList extends ArrayAdapter<Result> {

    public ResultList(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ResultList(Context context, int resource, List<Result> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.result_info, null);
        }

        Result p = getItem(position);

        if (p != null) {
            TextView winner1 = (TextView) v.findViewById(R.id.winnerPlayer1);
            TextView winner2 = (TextView) v.findViewById(R.id.winnerPlayer2);
            TextView loser1 = (TextView) v.findViewById(R.id.loserPlayer1);
            TextView loser2 = (TextView) v.findViewById(R.id.loserPlayer2);
            TextView cups = (TextView) v.findViewById(R.id.cups);

            if (winner1 != null) {
                winner1.setText(p.get_winner1());
            }

            if (winner2 != null) {
                winner2.setText(p.get_winner2());
            }

            if (loser1 != null) {
                loser1.setText(p.get_loser1());
            }

            if (loser2 != null) {
                loser2.setText(p.get_loser2());
            }

            if (cups != null) {
                cups.setText(Integer.toString(p.get_cupsleft()));
            }
        }

        return v;
    }

}

