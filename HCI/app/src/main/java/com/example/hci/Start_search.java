package com.example.hci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Start_search extends AppCompatActivity {

    Button cvchoice, profilechoice, favoritechoice, logoutbtn;
    TextView viewall;
    boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isLoggedIn = extras.getBoolean("Login");
            //The key argument here must match that used in the other activity
        } else {
            isLoggedIn = false;
        }

        cvchoice = findViewById(R.id.cv_choice);
        cvchoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContinueCV();
            }
        });

        profilechoice = findViewById(R.id.profile_choice);
        profilechoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContinueForm();
            }
        });

        favoritechoice = findViewById(R.id.viewfavorite_button);
        favoritechoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Viewall();
            }
        });

        logoutbtn = findViewById(R.id.logout_button);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });

        viewall = findViewById(R.id.viewall);
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Viewall();
            }
        });

        Button loginbutton = findViewById(R.id.loginTextview);

        if (!isLoggedIn)
        {
            loginbutton.setText("Đăng nhập");
            loginbutton.setCompoundDrawables(getDrawable(R.drawable.login), null, null, null);

            favoritechoice.setVisibility(View.INVISIBLE);
            logoutbtn.setVisibility(View.INVISIBLE);

            loginbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Login();
                }
            });
        } else {
            loginbutton.setText("Xin chào, Người Dùng.");
            loginbutton.setCompoundDrawables(null, null, null, null);

            favoritechoice.setVisibility(View.VISIBLE);
            logoutbtn.setVisibility(View.VISIBLE);

            loginbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { }
            });
        }
    }

    void ContinueCV()
    {
        Intent switchActivityIntent = new Intent(this, form_step_1.class);
        startActivity(switchActivityIntent);
    }

    void Login()
    {
        Intent switchActivityIntent = new Intent(this, login.class);
        startActivity(switchActivityIntent);
    }

    void Logout()
    {
        Intent switchActivityIntent = new Intent(this, Start_search.class);
        startActivity(switchActivityIntent);
    }

    void ContinueForm()
    {
        Intent switchActivityIntent = new Intent(this, search.class);
        startActivity(switchActivityIntent);
    }

    void Results()
    {
        Intent switchActivityIntent = new Intent(this, results.class);
        startActivity(switchActivityIntent);
    }

    void Viewall()
    {
        Intent switchActivityIntent = new Intent(this, results.class);
        switchActivityIntent.putExtra("viewall", true);
        startActivity(switchActivityIntent);
    }
}