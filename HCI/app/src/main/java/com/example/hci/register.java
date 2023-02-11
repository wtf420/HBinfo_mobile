package com.example.hci;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hci.databinding.ActivityRegisterBinding;

public class register extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityRegisterBinding binding;

    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Return();
            }
        });

        btn2 = findViewById(R.id.return_button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    void Return()
    {
        Intent switchActivityIntent = new Intent(this, login.class);
        switchActivityIntent.putExtra("Login", false);
        startActivity(switchActivityIntent);
    }

    void Register()
    {
        Intent switchActivityIntent = new Intent(this, login.class);
        switchActivityIntent.putExtra("Login", true);
        startActivity(switchActivityIntent);
    }
}