package com.example.mvvmexempel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmexempel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);
        binding.setLifecycleOwner(this);

        loginViewModel.getLoginResultLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isValid) {
                if(isValid){
//                    Toast.makeText(MainActivity.this,"inloggning lyckades", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MemberActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"fel användarnamn / lösenord", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginViewModel.getregisteredResultLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null){
                    String message = "User " + user.getUserName() + " registered.";
                    Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}