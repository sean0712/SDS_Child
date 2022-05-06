package com.teamProject2.sdschild;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MarketEditActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    EditText EditName, EditAmount, EditCount;
    Button BtnEdit, BtnDelete, BtnUpload, BtnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_edit);

        EditName = findViewById(R.id.EditName);
        EditAmount = findViewById(R.id.EditAmount);
        EditCount = findViewById(R.id.EditCount);

        BtnEdit = findViewById(R.id.BtnEdit);
        BtnDelete = findViewById(R.id.BtnDelete);
        BtnUpload = findViewById(R.id.BtnUpload);
        BtnCancel = findViewById(R.id.BtnCancel);


    }
}
