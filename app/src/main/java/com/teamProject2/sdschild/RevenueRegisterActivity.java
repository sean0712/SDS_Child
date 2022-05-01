package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RevenueRegisterActivity extends AppCompatActivity {

    EditText EditTitle, EditContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue_register);

        Intent intent = getIntent();
        Revenue revenue = (Revenue) intent.getSerializableExtra("date");
    }
}
