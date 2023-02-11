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

public class form_step_2 extends AppCompatActivity {

    Button nextbtn, homebtn, returnbtn;
    Spinner extraskillselect, activityhistoryselect;
    String[] diemmanh = {"Trình độ chuyên môn giỏi",
            "Thông thạo nhiều thứ tiếng (tiếng Anh, tiếng Trung, tiếng Nhật, tiếng Hàn,...)",
            "Thành thạo tin học văn phòng",
            "Trung thực, đáng tin cậy",
            "Tinh thần trách nhiệm cao",
            "Nhiệt tình, hăng hái, không ngại khó ngại khổ",
            "Khả năng tư duy sáng tạo",
            "Vui vẻ, tích cực với mọi người xung quanh",
            "Tinh thần cầu tiến",
            "Kỹ năng giao tiếp tốt",
            "Làm việc có nguyên tắc, đúng giờ",
            "Kỹ năng làm việc nhóm",
            "Kỹ năng giải quyết vấn đề",
            "Kỹ năng đàm phán, thương lượng",
            "Kỹ năng bán hàng",
            "Có nhiều tài lẻ (biết ca hát, chơi đàn, chơi sáo, làm MC,..)",
    };
    String[] diemyeu = {"Nhạy cảm quá mức",
            "Mất kiên nhẫn, cả thèm chóng chán",
            "Không dám phát biểu trước đám đông",
            "Tính háo thắng",
            "Làm việc và ra quyết định thiên về cảm tính",
            "Không lập kế hoạch rõ ràng trước khi thực hiện",
            "Bảo thủ, không bao giờ lắng nghe góp ý của người khác",
            "Khả năng tính toán kém",
            "Sống ích kỷ, không có thói quen chia sẻ",
            "Dễ nổi nóng và mất bình tĩnh",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_step2);

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
                = new ArrayAdapter(this,android.R.layout.simple_list_item_1,diemmanh);
        MultiAutoCompleteTextView diemmanhtextview = findViewById(R.id.diemmanh);
        diemmanhtextview.setAdapter(adapter);
        diemmanhtextview.setThreshold(1);
        diemmanhtextview.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        ArrayAdapter adapter2
                = new ArrayAdapter(this,android.R.layout.simple_list_item_1,diemyeu);
        MultiAutoCompleteTextView diemyeutextview = findViewById(R.id.diemyeu);
        diemyeutextview.setAdapter(adapter2);
        diemyeutextview.setThreshold(1);
        diemyeutextview.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    void Continue()
    {
        Intent switchActivityIntent = new Intent(this, form_step_3.class);
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