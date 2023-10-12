package com.example.sharedprefsex;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataManager {

    private SharedPreferences sp;
    private Context context;

    public DataManager(Context context){

        this.context = context;
        this.sp = context.getSharedPreferences("com.example.sharedprefsex.prefs", MODE_PRIVATE);

    }


    public void saveDataToFile(String textToSave) {
        if (!textToSave.isEmpty()) {
            File folder = new File(context.getFilesDir(), "MyFolder");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File textFile = new File(folder, "sample.txt");

            try {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(textFile, true)));
                writer.append(textToSave);
                writer.flush();         //flush() is included in the close() method in printwriters but not in filewriter
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String loadFromFile() {

        File readFile = new File(context.getFilesDir(),"/MyFolder/sample.txt");
        try {
            Scanner scanner = new Scanner(readFile);
            String s = scanner.nextLine();
            return s;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveStringToSharedPrefs(String key, String value){
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(key, value);
        editor.apply();
    }

    public String loadStringFromSharedPrefs(String key){
        String value = sp.getString(key, "key not found");
        return value;
    }
}
