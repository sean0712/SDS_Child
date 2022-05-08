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

import java.text.SimpleDateFormat;
import java.util.Date;

public class RevenueRegisterActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    EditText EditTitle, EditContent;
    Button BtnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue_register);

        Intent intent = getIntent();
        Revenue revenue = (Revenue) intent.getSerializableExtra("date");
//        String totalAmountString = intent.getStringExtra("totalAmountString");

        EditTitle = findViewById(R.id.EditTitle);
        EditContent = findViewById(R.id.EditContent);
        String title = "국세청 - 세금 게시 (" + revenue.date + ")";
        EditTitle.setText(title);
        String content = "세금 게시일: " + revenue.date + "\n\n이번 달 세금: " + System.amount +"미소 \n\n" + "작성자: "+ User.name;
        EditContent.setText(content);

        BtnRegister = findViewById(R.id.BtnRegister);

        BtnRegister.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String time1 = simpleDateFormat.format(date);
                addBoard(title, User.name, "revenue", content, time1);
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addBoard(String title, String author, String type, String content, String date) {
//        Revenue revenue = new Revenue(date, history, amount);
//        databaseReference.child("revenue").child(date).setValue(revenue);
        Board board = new Board(title, author, type, content, date);
        databaseReference.child("board").child(title.toString()).setValue(board);
    }
}
