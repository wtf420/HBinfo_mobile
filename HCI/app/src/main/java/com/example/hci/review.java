package com.example.hci;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class review extends AppCompatActivity {

    Button homebtn, returnbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        returnbtn = findViewById(R.id.return_button);
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Return();
            }
        });
    }

    void Return()
    {
        Intent switchActivityIntent = new Intent(this, results.class);
        startActivity(switchActivityIntent);
    }
}

