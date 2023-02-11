package com.example.hci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class results extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    boolean viewall = false;

    int[] schoolname = {R.string.fpt_schoolname, R.string.uit_schoolname, R.string.hcmut_schoolname};
    String[] desciptions = {"Học bổng lên tới 40%", "Học bổng lên tới 60%", "Học bổng lên tới 80%"};

    int[] tag = {R.drawable.fpttag, R.drawable.uittag, R.drawable.hcmutetag};
    int[] avatar = {R.drawable.fptview, R.drawable.uitview, R.drawable.hcmuteview};

    Button homebtn, redobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        recyclerView = findViewById(R.id.results);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ProgramAdapter(this, schoolname, desciptions, tag, avatar);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        //ViewDetail(position);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        //ViewDetail(position);
                    }
                })
        );

        homebtn = findViewById(R.id.home_button);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });

        redobtn = findViewById(R.id.redo_button);
        redobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Redo();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            viewall = extras.getBoolean("viewall");
            if (viewall)
            {
                TextView t;
                t = findViewById(R.id.extra_skill_label);
                t.setText("Danh sách các học bổng:");
            }
        }

    }

    void Redo()
    {
        Intent switchActivityIntent = new Intent(this, Start_search.class);
        startActivity(switchActivityIntent);
    }

    void Home()
    {
        Intent switchActivityIntent = new Intent(this, tittle_screen.class);
        startActivity(switchActivityIntent);
    }

    void ViewDetail(int index)
    {
        Intent switchActivityIntent = new Intent(this, results_detail.class);
        switchActivityIntent.putExtra("index", index);
        if (viewall)
        {
            switchActivityIntent.putExtra("viewall", true);
        }
        startActivity(switchActivityIntent);
    }
}

