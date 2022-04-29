package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class RevenueEditActivity extends AppCompatActivity {

    Button BtnIncome, BtnExpenditure;
    EditText EditDate, EditHistory, EditAmount;
    Button BtnEdit, BtnDelete, BtnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue_edit);

        BtnIncome = findViewById(R.id.BtnIncome);
        BtnExpenditure = findViewById(R.id.BtnExpenditure);
        EditDate = findViewById(R.id.EditDate);
        EditHistory = findViewById(R.id.EditHistory);
        EditAmount = findViewById(R.id.EditAmount);
        BtnEdit = findViewById(R.id.BtnEdit);
        BtnDelete = findViewById(R.id.BtnDelete);
        BtnCancel = findViewById(R.id.BtnCancel);

        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        String clubName = intent.getStringExtra("clubName");

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(RevenueEditActivity.this, intent.getStringExtra("date"), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
