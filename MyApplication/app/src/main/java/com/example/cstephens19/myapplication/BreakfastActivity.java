package com.example.cstephens19.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class BreakfastActivity extends AppCompatActivity {

    public Context context;

    //initialized here but used elsewhere
    public ArrayList<ArrayList<ArrayList<String>>> fullMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_breakfast);
        TextView t = (TextView) findViewById(R.id.BreakfastView);




        //adds all items that are of type breakfast to the textview
        //gets the full menu
        ArrayList<Menu> initItems = FileUtil.readFromFile(context);
        //selects all the items of type "Dinner" and creates list
        ArrayList<Menu> items = FileUtil.returnListOfItemsWith(initItems, "Breakfast");

        //adds all items that are of type Dinner to the textview
        for (int i = 0; i < items.size(); i++) {
            t.append(items.get(i).getSection() + ":");
            t.append(items.get(i).getItems());
            t.append("\n");
        }
    }


}
