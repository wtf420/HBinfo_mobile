package com.example.hci;

import android.annotation.SuppressLint;
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

import com.example.hci.databinding.ActivityViewReviewBinding;

public class view_review extends AppCompatActivity {

    Button homebtn, returnbtn;
    int index;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            index = extras.getInt("index");
            //The key argument here must match that used in the other activity
        } else {
            index = 1;
        }

        returnbtn = findViewById(R.id.return_button2);
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Return();
            }
        });
    }

    void Return()
    {
        Intent switchActivityIntent = new Intent(this, results_detail.class);
        switchActivityIntent.putExtra("index", index);
        startActivity(switchActivityIntent);
    }
}