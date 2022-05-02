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

        EditTitle = findViewById(R.id.EditTitle);
        EditContent = findViewById(R.id.EditContent);
        EditTitle.setText("[국세청] 세금 게시 (" + revenue.date + ")");
        String content = "세금 게시일: " + revenue.date + "\n\n남은 세금: " + " 00 미소 \n\n" + "작성자: "+ User.name;
        EditContent.setText(content);

        BtnRegister = findViewById(R.id.BtnRegister);

        BtnRegister.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBoard((System.boardSequence++).toString(), User.name, "revenue", content, System.date);
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

    }

    public void addBoard(String id, String author, String type, String content, String date) {
//        Revenue revenue = new Revenue(date, history, amount);
//        databaseReference.child("revenue").child(date).setValue(revenue);
        Board board = new Board(id, author, type, content, date);
        databaseReference.child("board").child(id.toString()).setValue(board);
    }
}
