package com.example.cstephens19.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OptionsActivity extends AppCompatActivity {

    public ArrayList<ArrayList<ArrayList<String>>> fullMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void showBreakfastMenu(View view){
        Intent intent = new Intent(this, BreakfastActivity.class);
        startActivity(intent);

    }

    public void showLunchMenu(View view) {
        Intent intent = new Intent(this, LunchActivity.class);
        startActivity(intent);
    }

    public void showDinnerMenu(View view) {
        Intent intent = new Intent(this, DinnerActivity.class);
        startActivity(intent);
    }


}
