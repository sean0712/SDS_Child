package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RevenueActivity extends AppCompatActivity {

    Button BtnRecord;
    Button BtnPost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        BtnRecord = findViewById(R.id.BtnRecord);
        BtnPost = findViewById(R.id.BtnPost);

        BtnRecord.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RevenueAddActivity.class);
                startActivity(intent);
            }
        });

        BtnPost.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RevenueRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
