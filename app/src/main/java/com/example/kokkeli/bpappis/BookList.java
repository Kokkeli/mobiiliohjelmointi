package com.example.kokkeli.bpappis;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookList extends ArrayAdapter<Book> {

    public BookList(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public BookList(Context context, int resource, List<Book> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.book_info, null);
        }

        Book p = getItem(position);

        if (p != null) {
            TextView nameView = (TextView) v.findViewById(R.id.bookName);
            TextView numberView = (TextView) v.findViewById(R.id.bookNumber);
            TextView yearView = (TextView) v.findViewById(R.id.bookYear);
            TextView ratingView = (TextView) v.findViewById(R.id.bookRating);

            if (nameView != null) {
                nameView.setText(p.get_name());
            }

            if (numberView != null) {
                numberView.setText(Integer.toString(p.get_number()));
            }

            if (yearView != null) {
                yearView.setText(Integer.toString(p.get_year()));
            }

            if (ratingView != null) {
                ratingView.setText(Integer.toString(p.get_rating()));
            }
        }

        return v;
    }

}

