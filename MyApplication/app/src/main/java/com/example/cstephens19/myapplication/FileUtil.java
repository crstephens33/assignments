package com.example.cstephens19.myapplication;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by aprasad on 1/29/17.
 */

//USED TO EXTRACT VAL DATA USING THE MENU CLASS. FILE WRITTEN BY PROFESSOR apraad

public class FileUtil {


    public static ArrayList<Menu> readFromFile(Context ctx)
    {
        ArrayList<Menu> menuItems = new ArrayList<>();

        InputStream inputStream = ctx.getResources().openRawResource(R.raw.val);
        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;


        try {
            while (( line = buffreader.readLine()) != null) {

                Menu m = new Menu();
                Log.d("FileUtil", line);
                String[] parts = line.split(",");
                m.setType(parts[0]);
                m.setSection(parts[1]);
                m.setItems(parts[2]);
                menuItems.add(m);
//                text.append(line);
//                text.append('\n');
            }
        } catch (IOException e) {
            return null;
        }

        return menuItems;
    }

    public static ArrayList<Menu> returnListOfItemsWith(ArrayList<Menu> items, String select) {

        ArrayList<Menu> result = new ArrayList<Menu>();

        for (int i = 0; i < items.size(); i++) {
            Menu m = items.get(i);

            if (m.getType().equals(select)) {
                result.add(m);
            }
        }
        return result;

    }


}
