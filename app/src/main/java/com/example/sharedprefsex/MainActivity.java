package com.example.sharedprefsex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    EditText inputField;
    TextView displayText;
    Button saveButton;
    Button loadButton;
    DataManager dataManager;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.et_input);
        displayText = findViewById(R.id.textView);
        loadButton = findViewById(R.id.btn_load);
        saveButton = findViewById(R.id.btn_save);

        dataManager = new DataManager(this);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataManager.saveDataToFile(inputField.getText().toString());


//          -----------Shared Prefs----------

//          String s = inputField.getText().toString();
//          dataManager.saveStringToSharedPrefs("name", s);

            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = dataManager.loadFromFile();
                displayText.setText(text);

//              ---------Shared Prefs-----------

//              String s = dataManager.loadStringFromSharedPrefs("name");
//              displayText.setText(s);
            }
        });


    }
}