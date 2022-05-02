package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

public class RevenueEditActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Button BtnIncome, BtnExpenditure;
    EditText EditDate, EditHistory, EditAmount;
    Button BtnEdit, BtnDelete, BtnCancel;
    Button BtnPost;

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
        BtnPost = findViewById(R.id.BtnPost);

        Intent intent = getIntent();
        Revenue revenue = (Revenue) intent.getSerializableExtra("date");

        EditDate.setText(revenue.date);
        EditHistory.setText(revenue.content);
        EditAmount.setText(revenue.amount);

        BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editRevenue(EditDate.getText().toString(),EditHistory.getText().toString(), EditAmount.getText().toString());
                RevenueEditActivity.super.onRestart();
                finish();
            }
        });

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteRevenue(EditDate.getText().toString());
                RevenueEditActivity.super.onRestart();
                finish();
            }
        });

        BtnPost.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RevenueRegisterActivity.class);
//
//                startActivity(intent);
                Intent intent = new Intent(getApplicationContext(), RevenueRegisterActivity.class);
                intent.putExtra("date", revenue);
                startActivity(intent);
            }
        });

        BtnCancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void editRevenue(String date, String history, String amount) {
        Revenue revenue = new Revenue(date, history, amount);
        databaseReference.child("revenue").child(date).setValue(revenue);
    }

    public void deleteRevenue(String date) {
        databaseReference.child("revenue").child(date).setValue(null);
    }
}
