package com.cookandroid.sdschild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {

    ImageButton btn_notice;
    ImageButton btn_board;
    ImageButton btn_photo;
    ImageButton btn_calendar;
    ImageButton btn_invest;
    ImageButton btn_job;
    ImageButton btn_my_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_notice = findViewById(R.id.btn_notice);
        btn_board = findViewById(R.id.btn_board);
        btn_photo = findViewById(R.id.btn_photo);
        btn_calendar = findViewById(R.id.btn_calendar);
        btn_invest = findViewById(R.id.btn_invest);
        btn_job = findViewById(R.id.btn_job);
        btn_my_page = findViewById(R.id.btn_my_page);

        btn_notice.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        btn_board.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

        btn_photo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
                startActivity(intent);
            }
        });

        btn_calendar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(intent);
            }
        });

        btn_invest.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InvestActivity.class);
                startActivity(intent);
            }
        });

        btn_job.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JobActivity.class);
                startActivity(intent);
            }
        });

        btn_my_page.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyPageActivity.class);
                startActivity(intent);
            }
        });


    }

//    btn_notice = findViewById(R.id.)
//    btn_board;
//    btn_photo;
//    btn_calendar;
//    btn_invest;
//    btn_job;
//    btn_my_page;
}