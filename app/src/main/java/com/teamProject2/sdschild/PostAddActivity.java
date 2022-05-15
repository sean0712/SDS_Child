package com.teamProject2.sdschild;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostAddActivity extends AppCompatActivity {

    Button BtnAdd ; // 과제 추가 버튼
    EditText etHome ; // 과제명
    EditText etDate; // 마감 기한
    CheckBox sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12,sub13,sub14,sub15;
    CheckBox ret1,ret2,ret3,ret4,ret5,ret6,ret7,ret8,ret9,ret10,ret11,ret12,ret13,ret14,ret15;


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

        sub1 = findViewById(R.id.add_cb5);
        sub2 = findViewById(R.id.add_cb7);
        sub3 = findViewById(R.id.add_cb9);
        sub4 = findViewById(R.id.add_cb11);
        sub5 = findViewById(R.id.add_cb13);
        sub6 = findViewById(R.id.add_cb15);
        sub7 = findViewById(R.id.add_cb17);
        sub8 = findViewById(R.id.add_cb19);
        sub9 = findViewById(R.id.add_cb21);
        sub10 = findViewById(R.id.add_cb23);
        sub11 = findViewById(R.id.add_cb25);
        sub12 = findViewById(R.id.add_cb27);
        sub13 = findViewById(R.id.add_cb29);
        sub14 = findViewById(R.id.add_cb31);
        sub15 = findViewById(R.id.add_cb33);


        ret1 = findViewById(R.id.add_cb6);
        ret2 = findViewById(R.id.add_cb8);
        ret3 = findViewById(R.id.add_cb10);
        ret4 = findViewById(R.id.add_cb12);
        ret5 = findViewById(R.id.add_cb14);
        ret6 = findViewById(R.id.add_cb16);
        ret7 = findViewById(R.id.add_cb18);
        ret8 = findViewById(R.id.add_cb20);
        ret9 = findViewById(R.id.add_cb22);
        ret10 = findViewById(R.id.add_cb24);
        ret11 = findViewById(R.id.add_cb26);
        ret12 = findViewById(R.id.add_cb28);
        ret13 = findViewById(R.id.add_cb30);
        ret14 = findViewById(R.id.add_cb32);
        ret15 = findViewById(R.id.add_cb34);



        BtnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addPostList(etHome.getText().toString(), etDate.getText().toString(),sub1.isChecked(),sub2.isChecked(),sub3.isChecked(),sub4.isChecked(),sub5.isChecked(),sub6.isChecked(),sub7.isChecked(),sub8.isChecked(),sub9.isChecked(),sub10.isChecked(),sub11.isChecked(),sub12.isChecked(),sub13.isChecked(),sub14.isChecked(),sub15.isChecked(), ret1.isChecked(), ret2.isChecked(), ret3.isChecked(), ret4.isChecked(), ret5.isChecked(), ret6.isChecked(), ret7.isChecked(), ret8.isChecked(), ret9.isChecked(), ret10.isChecked(), ret11.isChecked(), ret12.isChecked(), ret13.isChecked(), ret14.isChecked(), ret15.isChecked());
                PostAddActivity.super.onRestart();
                finish();
            }
        });

    }

    public void addPostList(String homework, String date, boolean sub1, boolean sub2, boolean sub3, boolean sub4, boolean sub5, boolean sub6, boolean sub7, boolean sub8, boolean sub9, boolean sub10, boolean sub11, boolean sub12, boolean sub13, boolean sub14, boolean sub15, boolean ret1, boolean ret2, boolean ret3, boolean ret4, boolean ret5, boolean ret6, boolean ret7, boolean ret8, boolean ret9, boolean ret10, boolean ret11, boolean ret12, boolean ret13, boolean ret14, boolean ret15){ // 새로운 과제 체크 리스트 만드는 것
        PostHomework ph = new PostHomework(homework,date,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12,sub13,sub14,sub15,ret1,ret2,ret3,ret4,ret5,ret6,ret7,ret8,ret9,ret10,ret11,ret12,ret13,ret14,ret15);
        databaseReference.child("homework").child(homework).setValue(ph);

    }


}
