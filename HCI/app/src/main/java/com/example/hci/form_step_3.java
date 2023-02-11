package com.example.hci;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

public class form_step_3 extends AppCompatActivity {

    Button nextbtn, homebtn, returnbtn;
    Spinner activityhistoryselect;
    String[] answer = {"Thêm kiến thức chuyên môn",
            "Cần đầu tư",
            "Cần người hướng dẫn",
            "Cần trải nghiệm thực tế"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_step3);

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

        activityhistoryselect = findViewById(R.id.activity_history_select);
        activityhistoryselect.setOnItemSelectedListener(OnCatSpinnerCL);

        ArrayAdapter adapter
                = new ArrayAdapter(this,android.R.layout.simple_list_item_1,answer);
        MultiAutoCompleteTextView diemmanhtextview = findViewById(R.id.answer);
        diemmanhtextview.setAdapter(adapter);
        diemmanhtextview.setThreshold(1);
        diemmanhtextview.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    void Continue()
    {
        Intent switchActivityIntent = new Intent(this, form_step_4.class);
        startActivity(switchActivityIntent);
    }

    void Home()
    {
        Intent switchActivityIntent = new Intent(this, tittle_screen.class);
        startActivity(switchActivityIntent);
    }

    void Return()
    {
        Intent switchActivityIntent = new Intent(this, form_step_1.class);
        startActivity(switchActivityIntent);
    }
}