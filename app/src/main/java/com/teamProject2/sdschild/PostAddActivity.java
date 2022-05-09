package com.teamProject2.sdschild;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostAddActivity extends AppCompatActivity {

    Button BtnAdd ; // 과제 추가 버튼
    EditText etHome ;
    EditText etDate;

    // 파이어베이스 연결 위해 사용
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_post_add);

        BtnAdd=findViewById(R.id.add_btn);
        etHome=findViewById(R.id.add_et1);
        etDate=findViewById(R.id.add_et2);

        BtnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addPostList(etHome.getText().toString(), etDate.getText().toString());
                PostAddActivity.super.onRestart();
                finish();
            }
        });

    }

    public void addPostList(String homework, String date){ // 새로운 과제 체크 리스트 만드는 것
        PostHomework ph = new PostHomework(homework,date);
        databaseReference.child("homework").child(homework).setValue(ph);

    }

}
