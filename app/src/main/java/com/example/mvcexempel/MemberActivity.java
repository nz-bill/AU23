package com.example.mvcexempel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MemberActivity extends AppCompatActivity implements MemberContract.View{

    MemberContract.Presenter presenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        presenter = new MemberPresenter(new DataManager(), this);
        listView = findViewById(R.id.lv_members);

        presenter.onViewCreated();
    }

    @Override
    public void displayMembers(List<User> members) {

//      ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, members);
        MemberAdapter adapter = new MemberAdapter(this,members);
        listView.setAdapter(adapter);

    }
}