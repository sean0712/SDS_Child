package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WholesalerAddActivity extends AppCompatActivity {


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Button BtnAdd;
    Button BtnCancel;

    EditText EditName, EditAmount, EditCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_add);

        BtnAdd = findViewById(R.id.BtnAdd);
        BtnCancel = findViewById(R.id.BtnCancel);
        EditName = findViewById(R.id.EditName);
        EditAmount = findViewById(R.id.EditAmount);
        EditCount = findViewById(R.id.EditCount);

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                addRevenue(EditDate.getText().toString(),EditHistory.getText().toString(), EditAbsoluteAmount.getText().toString());
//                RevenueAddActivity.super.onRestart();
//                finish();
                addItem("URL", EditName.getText().toString(), EditAmount.getText().toString(), EditCount.getText().toString());
                WholesalerAddActivity.super.onRestart();
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

//    public void addItem(String date, String history, String amount) {
//        Revenue revenue = new Revenue(date, history, amount);
//        databaseReference.child("revenue").child(date).setValue(revenue);
//    }

    public void addItem(String poster, String name, String amount, String count) {
        Item item = new Item(poster, name, amount, count);
        databaseReference.child("warehouse").child(name).setValue(item);
    }
}
