package com.example.hci;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class results_detail extends AppCompatActivity {

    Button homebtn, returnbtn;
    ImageView imageView;
    TextView overView, textLabel;

    TextView dieukien, gioithieuso, cachlayhocbong, loiich, chungnhan, review;
    ScrollView scrollView;
    ToggleButton toggleButton;

    int index;
    boolean viewall = false;

    String[] schoolname = {"Trường ĐH FPT", "Trường ĐH Công nghệ thông tin", "Trường ĐH Sư phạm kĩ thuật"};
    int[] overviews = {R.string.fpt_description, R.string.uit_description, R.string.hcmute_description};
    int[] avatar = {R.drawable.fptview_detail, R.drawable.uitview_detail, R.drawable.hcmuteview_detail};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            index = extras.getInt("index");
            viewall = extras.getBoolean("viewall");
            //The key argument here must match that used in the other activity
        } else {
            index = 1;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_detail);

        returnbtn = findViewById(R.id.return_button);
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Return();
            }
        });

        scrollView = findViewById(R.id.scrollview);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(avatar[index]);
        textLabel = findViewById(R.id.text_label);
        textLabel.setText("Học bổng cho:\n" + schoolname[index]);
        textLabel.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        overView = findViewById(R.id.overview_detail);
        overView.setText(overviews[index]);

        review = findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Review();
            }
        });

        dieukien = findViewById(R.id.dieukien);
        dieukien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView label = findViewById(R.id.condition_label);
                scrollView.smoothScrollTo(0, label.getTop());
            }
        });

        gioithieuso = findViewById(R.id.gioithieuso);
        gioithieuso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView label = findViewById(R.id.overview_label);
                scrollView.smoothScrollTo(0, label.getTop());
            }
        });

        cachlayhocbong = findViewById(R.id.cachlayhocbong);
        cachlayhocbong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView label = findViewById(R.id.howto_label);
                scrollView.smoothScrollTo(0, label.getTop());
            }
        });

        loiich = findViewById(R.id.loiich);
        loiich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView label = findViewById(R.id.benefits_label);
                scrollView.smoothScrollTo(0, label.getTop());
            }
        });

        chungnhan = findViewById(R.id.chungnhan);
        chungnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView label = findViewById(R.id.certified_label);
                scrollView.smoothScrollTo(0, label.getTop());
            }
        });

        toggleButton = findViewById(R.id.toggleButton2);
        toggleButton.setChecked(false);
        toggleButton.setBackgroundResource(R.drawable.favourite);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    toggleButton.setBackgroundResource(R.drawable.favourited);
                else
                    toggleButton.setBackgroundResource(R.drawable.favourite);
            }
        });
    }

    void Return()
    {
        Intent switchActivityIntent = new Intent(this, results.class);
        switchActivityIntent.putExtra("viewall", viewall);
        startActivity(switchActivityIntent);
    }

    void Review()
    {
        Intent switchActivityIntent = new Intent(this, view_review.class);
        switchActivityIntent.putExtra("index", index);
        startActivity(switchActivityIntent);
    }
}

