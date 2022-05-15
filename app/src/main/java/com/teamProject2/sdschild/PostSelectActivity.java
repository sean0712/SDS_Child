package com.teamProject2.sdschild;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostSelectActivity extends AppCompatActivity {

    // 파이어베이스 연결 위해 사용
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();


    TextView tv1,tv2;
    Button btnmod;
    Button btndel;
    CheckBox sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12,sub13,sub14,sub15;
    CheckBox ret1,ret2,ret3,ret4,ret5,ret6,ret7,ret8,ret9,ret10,ret11,ret12,ret13,ret14,ret15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_selected_post);

        Intent intent = getIntent();
        PostHomework posthomework = (PostHomework) intent.getSerializableExtra("date");

        btnmod = findViewById(R.id.btn_modifyPost);
        btndel = findViewById(R.id.post_del);
        // 버튼 할당
        tv1=findViewById(R.id.post_sel_homeworktextview);
        tv2=findViewById(R.id.post_sel_dateTextVIew);

        sub1=findViewById(R.id.selpost_cb5);
        ret1=findViewById(R.id.selpost_cb6);
        sub2=findViewById(R.id.selpost_cb7);
        ret2=findViewById(R.id.selpost_cb8);

        sub3=findViewById(R.id.selpost_cb9);
        ret3=findViewById(R.id.selpost_cb10);
        sub4=findViewById(R.id.selpost_cb11);
        ret4=findViewById(R.id.selpost_cb12);

        sub5=findViewById(R.id.selpost_cb13);
        ret5=findViewById(R.id.selpost_cb14);
        sub6=findViewById(R.id.selpost_cb15);
        ret6=findViewById(R.id.selpost_cb16);

        sub7=findViewById(R.id.selpost_cb17);
        ret7=findViewById(R.id.selpost_cb18);
        sub8=findViewById(R.id.selpost_cb19);
        ret8=findViewById(R.id.selpost_cb20);

        sub9=findViewById(R.id.selpost_cb21);
        ret9=findViewById(R.id.selpost_cb22);
        sub10=findViewById(R.id.selpost_cb23);
        ret10=findViewById(R.id.selpost_cb24);

        sub11=findViewById(R.id.selpost_cb25);
        ret11=findViewById(R.id.selpost_cb26);
        sub12=findViewById(R.id.selpost_cb27);
        ret12=findViewById(R.id.selpost_cb28);

        sub13=findViewById(R.id.selpost_cb29);
        ret13=findViewById(R.id.selpost_cb30);
        sub14=findViewById(R.id.selpost_cb31);
        ret14=findViewById(R.id.selpost_cb32);
        sub15=findViewById(R.id.selpost_cb33);
        ret15=findViewById(R.id.selpost_cb34);


// 파이어베이스 값 넣기
        tv1.setText(posthomework.homework);
        tv2.setText(posthomework.date);

        sub1.setChecked(posthomework.sub1);
        ret1.setChecked(posthomework.ret1);
        sub2.setChecked(posthomework.sub2);
        ret2.setChecked(posthomework.ret2);

        sub3.setChecked(posthomework.sub3);
        ret3.setChecked(posthomework.ret3);
        sub4.setChecked(posthomework.sub4);
        ret4.setChecked(posthomework.ret4);

        sub6.setChecked(posthomework.sub6);
        ret6.setChecked(posthomework.ret6);
        sub7.setChecked(posthomework.sub7);
        ret8.setChecked(posthomework.ret8);

        sub9.setChecked(posthomework.sub9);
        ret9.setChecked(posthomework.ret9);
        sub10.setChecked(posthomework.sub10);
        ret10.setChecked(posthomework.ret10);

        sub11.setChecked(posthomework.sub11);
        ret11.setChecked(posthomework.ret11);
        sub12.setChecked(posthomework.sub12);
        ret12.setChecked(posthomework.ret12);

        sub13.setChecked(posthomework.sub13);
        ret13.setChecked(posthomework.ret13);
        sub14.setChecked(posthomework.sub14);
        ret14.setChecked(posthomework.ret14);
        sub15.setChecked(posthomework.sub15);
        ret15.setChecked(posthomework.ret15);


        btnmod.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addPostList(tv1.getText().toString(), tv2.getText().toString(),sub1.isChecked(),sub2.isChecked(),sub3.isChecked(),sub4.isChecked(),sub5.isChecked(),sub6.isChecked(),sub7.isChecked(),sub8.isChecked(),sub9.isChecked(),sub10.isChecked(),sub11.isChecked(),sub12.isChecked(),sub13.isChecked(),sub14.isChecked(),sub15.isChecked(), ret1.isChecked(), ret2.isChecked(), ret3.isChecked(), ret4.isChecked(), ret5.isChecked(), ret6.isChecked(), ret7.isChecked(), ret8.isChecked(), ret9.isChecked(), ret10.isChecked(), ret11.isChecked(), ret12.isChecked(), ret13.isChecked(), ret14.isChecked(), ret15.isChecked());
                finish();
            }
        });


        btndel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                delPostList(tv1.getText().toString(), tv2.getText().toString(),sub1.isChecked(),sub2.isChecked(),sub3.isChecked(),sub4.isChecked(),sub5.isChecked(),sub6.isChecked(),sub7.isChecked(),sub8.isChecked(),sub9.isChecked(),sub10.isChecked(),sub11.isChecked(),sub12.isChecked(),sub13.isChecked(),sub14.isChecked(),sub15.isChecked(), ret1.isChecked(), ret2.isChecked(), ret3.isChecked(), ret4.isChecked(), ret5.isChecked(), ret6.isChecked(), ret7.isChecked(), ret8.isChecked(), ret9.isChecked(), ret10.isChecked(), ret11.isChecked(), ret12.isChecked(), ret13.isChecked(), ret14.isChecked(), ret15.isChecked());
                finish();
            }
        });


    }

    public void addPostList(String homework, String date, boolean sub1, boolean sub2, boolean sub3, boolean sub4, boolean sub5, boolean sub6, boolean sub7, boolean sub8, boolean sub9, boolean sub10, boolean sub11, boolean sub12, boolean sub13, boolean sub14, boolean sub15, boolean ret1, boolean ret2, boolean ret3, boolean ret4, boolean ret5, boolean ret6, boolean ret7, boolean ret8, boolean ret9, boolean ret10, boolean ret11, boolean ret12, boolean ret13, boolean ret14, boolean ret15){ // 새로운 과제 체크 리스트 만드는 것
        PostHomework ph = new PostHomework(homework,date,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12,sub13,sub14,sub15,ret1,ret2,ret3,ret4,ret5,ret6,ret7,ret8,ret9,ret10,ret11,ret12,ret13,ret14,ret15);
        databaseReference.child("homework").child(homework).setValue(ph);

    }

    public void delPostList(String homework, String date, boolean sub1, boolean sub2, boolean sub3, boolean sub4, boolean sub5, boolean sub6, boolean sub7, boolean sub8, boolean sub9, boolean sub10, boolean sub11, boolean sub12, boolean sub13, boolean sub14, boolean sub15, boolean ret1, boolean ret2, boolean ret3, boolean ret4, boolean ret5, boolean ret6, boolean ret7, boolean ret8, boolean ret9, boolean ret10, boolean ret11, boolean ret12, boolean ret13, boolean ret14, boolean ret15){ // 새로운 과제 체크 리스트 만드는 것
        PostHomework ph = new PostHomework(homework,date,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12,sub13,sub14,sub15,ret1,ret2,ret3,ret4,ret5,ret6,ret7,ret8,ret9,ret10,ret11,ret12,ret13,ret14,ret15);
        databaseReference.child("homework").child(homework).setValue(null);

    }

}
