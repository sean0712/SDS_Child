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

public class BoardViewActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    EditText EditTitle, EditContent;
    Button BtnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_view);

        Intent intent = getIntent();
        Board board = (Board) intent.getSerializableExtra("board");

        EditTitle = findViewById(R.id.EditTitle);
        EditContent = findViewById(R.id.EditContent);
        String title = "국세청 - 세금 게시 (" + board.title + ")";
        EditTitle.setText(title);
//        String content = "세금 게시일: " + revenue.date + "\n\n남은 세금: " + " 00 미소 \n\n" + "작성자: "+ User.name;
        String content = board.content;
        EditContent.setText(content);

        BtnCancel = findViewById(R.id.BtnCancel);

        BtnCancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
