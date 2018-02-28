package com.example.kokkeli.bpappis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


import java.util.*;

public class MainNavigation extends AppCompatActivity {

    private EditText plus1;
    private EditText plus2;
    private EditText miinus1;
    private EditText miinus2;
    private EditText kerto1;
    private EditText kerto2;
    private EditText jako1;
    private EditText jako2;

    private Button plusLaske;
    private Button miinusLaske;
    private Button kertoLaske;
    private Button jakoLaske;
    private Button naytaLogi;
    private Button tyhjenna;

    private TextView plusTulos;
    private TextView miinusTulos;
    private TextView kertoTulos;
    private TextView jakoTulos;

    public List<String> logi = new ArrayList<String>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        plus1 = (EditText) findViewById(R.id.plus1);
        plus2 = (EditText) findViewById(R.id.plus2);
        miinus1 = (EditText) findViewById(R.id.miinus1);
        miinus2 = (EditText) findViewById(R.id.miinus2);
        kerto1 = (EditText) findViewById(R.id.kerto1);
        kerto2 = (EditText) findViewById(R.id.kerto2);
        jako1 = (EditText) findViewById(R.id.jako1);
        jako2 = (EditText) findViewById(R.id.jako2);

        plusLaske = (Button) findViewById(R.id.pluslaske);
        miinusLaske = (Button) findViewById(R.id.miinuslaske);
        kertoLaske = (Button) findViewById(R.id.kertolaske);
        jakoLaske = (Button) findViewById(R.id.jakolaske);
        naytaLogi = (Button) findViewById(R.id.naytalogi);
        tyhjenna = (Button) findViewById(R.id.tyhjenna);

        plusTulos = (TextView) findViewById(R.id.plustulos);
        miinusTulos = (TextView) findViewById(R.id.miinustulos);
        kertoTulos = (TextView) findViewById(R.id.kertotulos);
        jakoTulos = (TextView) findViewById(R.id.jakotulos);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void pluslasku(android.view.View view) {
        float tulos;
        try
        {
            tulos = Float.valueOf(plus1.getText().toString()) + Float.valueOf(plus2.getText().toString());
            plusTulos.setText(Float.toString(tulos));
            String str = plus1.getText().toString() + " + " + Float.valueOf(plus2.getText().toString()) + " = " + Float.toString(tulos);
            logi.add(str);
        }
        catch (Exception e){
            // TODO: error handling
        }
    }

    public void miinuslasku(android.view.View view) {
        float tulos;
        try
        {
            tulos = Float.valueOf(miinus1.getText().toString()) - Float.valueOf(miinus2.getText().toString());
            miinusTulos.setText(Float.toString(tulos));
            String str = miinus1.getText().toString() + " - " + Float.valueOf(miinus2.getText().toString()) + " = " + Float.toString(tulos);
            logi.add(str);
        }
        catch (Exception e){
            // TODO: error handling
        }
    }

    public void kertolasku(android.view.View view) {
        float tulos;
        try
        {
            tulos = Float.valueOf(kerto1.getText().toString()) * Float.valueOf(kerto2.getText().toString());
            kertoTulos.setText(Float.toString(tulos));
            String str = kerto1.getText().toString() + " x " + Float.valueOf(kerto2.getText().toString()) + " = " + Float.toString(tulos);
            logi.add(str);
        }
        catch (Exception e){
            // TODO: error handling
        }
    }

    public void jakolasku(android.view.View view) {
        float tulos;
        try
        {
            tulos = Float.valueOf(jako1.getText().toString()) / Float.valueOf(jako2.getText().toString());
            jakoTulos.setText(Float.toString(tulos));
            String str = jako1.getText().toString() + " / " + Float.valueOf(jako2.getText().toString()) + " = " + Float.toString(tulos);
            logi.add(str);
        }
        catch (Exception e){
            // TODO: error handling
        }
    }

    public void tyhjenna(android.view.View view) {
        plusTulos.setText("0");
        miinusTulos.setText("0");
        kertoTulos.setText("0");
        jakoTulos.setText("0");
        plus1.setText("0");
        plus2.setText("0");
        miinus1.setText("0");
        miinus2.setText("0");
        kerto1.setText("0");
        kerto2.setText("0");
        jako1.setText("0");
        jako2.setText("0");
    }

    public void naytalogi(android.view.View view) {
        Intent intent = new Intent(getBaseContext(), LogActivity.class);
        intent.putStringArrayListExtra("logi", (ArrayList<String>) logi);
        startActivity(intent);
    }
 }
