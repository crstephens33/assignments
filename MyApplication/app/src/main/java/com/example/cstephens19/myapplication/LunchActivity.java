package com.example.cstephens19.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class LunchActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        context = this;
        TextView t = (TextView) findViewById(R.id.LunchView);


        //gets the full menu
        ArrayList<Menu> initItems = FileUtil.readFromFile(context);
        //selects all the items of type "breakfast" and creates list
        ArrayList<Menu> items = FileUtil.returnListOfItemsWith(initItems, "Lunch");

        //adds all items that are of type breakfast to the textview
        for (int i = 0; i < items.size(); i++) {
            t.append(items.get(i).getSection() + ":");
            t.append(items.get(i).getItems());
            t.append(". ");
        }
    }
}