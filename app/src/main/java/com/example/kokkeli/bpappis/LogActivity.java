package com.example.kokkeli.bpappis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.*;

public class LogActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        lv = (ListView) findViewById(R.id.listView);

        ArrayList<String> logi = getIntent().getStringArrayListExtra("logi");

        ArrayAdapter<String> adapteri = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                logi
        );

        lv.setAdapter(adapteri);
    }

}
