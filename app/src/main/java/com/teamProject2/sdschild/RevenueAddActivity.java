package com.teamProject2.sdschild;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RevenueAddActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Button BtnIncome;
    Button BtnExpenditure;
    Button BtnAdd;
    Button BtnCancel;
    EditText EditDate;
    EditText EditHistory;
    EditText EditAbsoluteAmount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue_add);

        BtnIncome = findViewById(R.id.BtnIncome);
        BtnExpenditure = findViewById(R.id.BtnExpenditure);
        BtnAdd = findViewById(R.id.BtnAdd);
        BtnCancel = findViewById(R.id.BtnCancel);
        EditDate = findViewById(R.id.EditDate);
        EditHistory = findViewById(R.id.EditHistory);
        EditAbsoluteAmount = findViewById(R.id.EditAbsoluteAmount);

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRevenue(EditDate.getText().toString(),EditHistory.getText().toString(), EditAbsoluteAmount.getText().toString());
                RevenueAddActivity.super.onRestart();
                finish();
            }
        });

        BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void addRevenue(String date, String history, String amount) {
//        User user = new User(date,history);
//        databaseReference.child("zoo").child(date).setValue(user);
        Revenue revenue = new Revenue(date, history, amount);
        databaseReference.child("revenue").child(date).setValue(revenue);
    }
}
