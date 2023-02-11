package com.example.hci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class form_step_4 extends AppCompatActivity {

    Button nextbtn, homebtn, returnbtn;
    Spinner country, school, finacial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_step4);

        nextbtn = findViewById(R.id.next_button);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Continue();
            }
        });

        homebtn = findViewById(R.id.home_button);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });

        returnbtn = findViewById(R.id.return_button);
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Return();
            }
        });

        AdapterView.OnItemSelectedListener OnCatSpinnerCL = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(20);

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        school = findViewById(R.id.spectialty_select);
        school.setOnItemSelectedListener(OnCatSpinnerCL);

        finacial = findViewById(R.id.financial_select);
        finacial.setOnItemSelectedListener(OnCatSpinnerCL);

        country = findViewById(R.id.country_select);
        country.setOnItemSelectedListener(OnCatSpinnerCL);
    }

    void Continue()
    {
        Intent switchActivityIntent = new Intent(this, results.class);
        startActivity(switchActivityIntent);
    }

    void Home()
    {
        Intent switchActivityIntent = new Intent(this, tittle_screen.class);
        startActivity(switchActivityIntent);
    }

    void Return()
    {
        Intent switchActivityIntent = new Intent(this, Start_search.class);
        startActivity(switchActivityIntent);
    }
}