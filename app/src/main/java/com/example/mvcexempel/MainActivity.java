package com.example.mvcexempel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userNameInput;
    EditText userPasswordInput;

    DataManager dataManager = new DataManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameInput = findViewById(R.id.et_name);
        userPasswordInput = findViewById(R.id.et_password);
        Button loginButton = findViewById(R.id.btn_login);
        Button registerButton = findViewById(R.id.btn_register);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userNameInput.getText().toString();
                String password = userPasswordInput.getText().toString();

                User u = dataManager.createUser(name,password);
                Toast.makeText(MainActivity.this, u.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userNameInput.getText().toString();
                String password = userPasswordInput.getText().toString();

                if(dataManager.validateUser(name, password)){
                    Intent intent = new Intent(MainActivity.this, MemberActivity.class);
                    startActivity(intent);
//                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "Login Failed, wrong username/password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}