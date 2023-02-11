package com.example.hci;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class login extends AppCompatActivity {

    Button loginbtn, returnbtn, registerbtn;
    TextView forgot_password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        returnbtn = findViewById(R.id.return_button2);
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Return();
            }
        });

        loginbtn = findViewById(R.id.button2);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

        registerbtn = findViewById(R.id.button5);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });

        forgot_password = findViewById(R.id.button3);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotPassword();
            }
        });
    }

    void Return()
    {
        Intent switchActivityIntent = new Intent(this, Start_search.class);
        switchActivityIntent.putExtra("Login", false);
        startActivity(switchActivityIntent);
    }

    void Login()
    {
        Intent switchActivityIntent = new Intent(this, Start_search.class);
        switchActivityIntent.putExtra("Login", true);
        startActivity(switchActivityIntent);
    }

    void Register()
    {
        Intent switchActivityIntent = new Intent(this, register.class);
        startActivity(switchActivityIntent);
    }

    void ForgotPassword()
    {
        Intent switchActivityIntent = new Intent(this, forgot_password.class);
        startActivity(switchActivityIntent);
    }
}