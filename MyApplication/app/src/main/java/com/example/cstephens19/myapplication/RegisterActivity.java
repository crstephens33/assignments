package com.example.cstephens19.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    EditText editU;
    EditText editP;
    EditText editC;
    TextView notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editU =  (EditText) findViewById(R.id.editRegisterUserName);
        editP =  (EditText) findViewById(R.id.editRegisterPassword);
        editC =  (EditText) findViewById(R.id.editRegisterConfirm);
        notif = (TextView)findViewById(R.id.headerText);


        editU.setHint("username");
        editP.setHint("password");
        editC.setHint("confirm");
    }

    public void doRegistration(View view){

        String username = editU.getText().toString();
        String password = editP.getText().toString();
        String confirm = editC.getText().toString();
        System.out.println("uname: " + username + " pw: " + password + " confirm: " + confirm);

        if (!password.equals(confirm)) {
            notif.setText("Password does not match confirmed password.");
        }
        else if (password.length() == 0) {
            notif.setText("Password must be at least 1 character");
        }
        else {
            String encoded = username + "." + password;
            System.out.println("Encoded: " + encoded);
            writeToFile(encoded, this.getApplicationContext());
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    private void writeToFile(String data, Context context) {
        try {
            String before = readFromFile(this.getApplicationContext());
            System.out.println("Before: " + before);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("accounts.txt", Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            String after = readFromFile(this.getApplicationContext());
            System.out.println("after: " + after);
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("accounts.txt");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public void openCamera (View view) {

        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
}
