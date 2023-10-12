package com.example.mvcexempel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MemberActivity extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        listView = findViewById(R.id.lv_members);

//        ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DataManager.users);
        MemberAdapter adapter = new MemberAdapter(this,DataManager.users);

        listView.setAdapter(adapter);
    }
}