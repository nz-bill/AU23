package com.example.mvcexempel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, MemberContract.View {

    MainContract.Presenter presenter;
    MemberContract.Presenter memberPresenter;

    EditText userNameInput;
    EditText userPasswordInput;
    ListView memberListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(new DataManager(), this, new Navigator(this));
        memberPresenter = new MemberPresenter(new DataManager(), this);

        memberListView = findViewById(R.id.lv_members);

        userNameInput = findViewById(R.id.et_name);
        userPasswordInput = findViewById(R.id.et_password);
        Button loginButton = findViewById(R.id.btn_login);
        Button registerButton = findViewById(R.id.btn_register);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegisterButtonClicked();
                memberPresenter.onViewCreated();

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLoginButtonClicked();
            }
        });

        presenter.onViewCreated();
    }

    @Override
    public void showLoginSuccessMessage() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoginFaildMessage() {
        Toast.makeText(this, "wrong username/ password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRegisteredSuccessMessage(User user) {
        String s ="user " + user.getUserName() + " registered";
        Toast.makeText(this,s , Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRegisteredFailedMessage() {
        Toast.makeText(this, "registration failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public String getUserName() {
        return userNameInput.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return userPasswordInput.getText().toString();
    }

    @Override
    public void displayMembers(List<User> members) {
        MemberAdapter adapter = new MemberAdapter(this,members);
        memberListView.setAdapter(adapter);
    }
}