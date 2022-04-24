package com.teamProject2.sdschild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    ImageButton BtnNotice;
    ImageButton BtnBoard;
    ImageButton BtnPhoto;
    ImageButton BtnCalendar;
    ImageButton BtnInvest;
    ImageButton BtnJob;
    ImageButton BtnMyPage;
    ImageButton BtnMarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BtnNotice = findViewById(R.id.BtnNotice);
        BtnBoard = findViewById(R.id.BtnBoard);
        BtnPhoto = findViewById(R.id.BtnPhoto);
        BtnCalendar = findViewById(R.id.BtnCalander);
        BtnInvest = findViewById(R.id.BtnInvest);
        BtnJob = findViewById(R.id.BtnJob);
        BtnMyPage = findViewById(R.id.BtnMyPage);
        BtnMarket = findViewById(R.id.BtnMarket);


        BtnNotice.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        BtnBoard.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

        BtnPhoto.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
                startActivity(intent);
            }
        });

        BtnCalendar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(intent);
            }
        });

        BtnInvest.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InvestActivity.class);
                startActivity(intent);
            }
        });

        BtnJob.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User.job.equals("Revenue")) {
                    Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
                    startActivity(intent);
                }
                else if (User.job.equals("Wholesaler")) {
                    Intent intent = new Intent(getApplicationContext(), WholesalerActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), JobActivity.class);
                    startActivity(intent);
                }
            }
        });

        BtnMarket.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MarketActivity.class);
                startActivity(intent);
            }
        });

        BtnMyPage.setOnClickListener(new Button.OnClickListener() {
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