package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisinfectModifyActivity extends AppCompatActivity {

    // 파이어베이스 연결 위해 사용
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();


    EditText ev1,ev2;
    Button btnmod;
    CheckBox sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12,sub13,sub14,sub15;
    CheckBox ret1,ret2,ret3,ret4,ret5,ret6,ret7,ret8,ret9,ret10,ret11,ret12,ret13,ret14,ret15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis_mod);

        Intent intent = getIntent();
        Disinfect dis = (Disinfect) intent.getSerializableExtra("date");

        btnmod = findViewById(R.id.dis_modify);

        // 버튼 할당
        ev1=findViewById(R.id.dism_date);
        ev2=findViewById(R.id.dism_disper);

        sub1=findViewById(R.id.dism_cb5);
        ret1=findViewById(R.id.dism_cb6);
        sub2=findViewById(R.id.dism_cb7);
        ret2=findViewById(R.id.dism_cb8);

        sub3=findViewById(R.id.dism_cb9);
        ret3=findViewById(R.id.dism_cb10);
        sub4=findViewById(R.id.dism_cb11);
        ret4=findViewById(R.id.dism_cb12);

        sub5=findViewById(R.id.dism_cb13);
        ret5=findViewById(R.id.dism_cb14);
        sub6=findViewById(R.id.dism_cb15);
        ret6=findViewById(R.id.dism_cb16);

        sub7=findViewById(R.id.dism_cb17);
        ret7=findViewById(R.id.dism_cb18);
        sub8=findViewById(R.id.dism_cb19);
        ret8=findViewById(R.id.dism_cb20);

        sub9=findViewById(R.id.dism_cb21);
        ret9=findViewById(R.id.dism_cb22);
        sub10=findViewById(R.id.dism_cb23);
        ret10=findViewById(R.id.dism_cb24);

        sub11=findViewById(R.id.dism_cb25);
        ret11=findViewById(R.id.dism_cb26);
        sub12=findViewById(R.id.dism_cb27);
        ret12=findViewById(R.id.dism_cb28);

        sub13=findViewById(R.id.dism_cb29);
        ret13=findViewById(R.id.dism_cb30);
        sub14=findViewById(R.id.dism_cb31);
        ret14=findViewById(R.id.dism_cb32);
        sub15=findViewById(R.id.dism_cb33);
        ret15=findViewById(R.id.dism_cb34);


// 파이어베이스 값 넣기
        ev1.setText(dis.date);
        ev2.setText(dis.disper);

        sub1.setChecked(dis.sub1);
        ret1.setChecked(dis.ret1);
        sub2.setChecked(dis.sub2);
        ret2.setChecked(dis.ret2);

        sub3.setChecked(dis.sub3);
        ret3.setChecked(dis.ret3);
        sub4.setChecked(dis.sub4);
        ret4.setChecked(dis.ret4);

        sub6.setChecked(dis.sub6);
        ret6.setChecked(dis.ret6);
        sub7.setChecked(dis.sub7);
        ret8.setChecked(dis.ret8);

        sub9.setChecked(dis.sub9);
        ret9.setChecked(dis.ret9);
        sub10.setChecked(dis.sub10);
        ret10.setChecked(dis.ret10);

        sub11.setChecked(dis.sub11);
        ret11.setChecked(dis.ret11);
        sub12.setChecked(dis.sub12);
        ret12.setChecked(dis.ret12);

        sub13.setChecked(dis.sub13);
        ret13.setChecked(dis.ret13);
        sub14.setChecked(dis.sub14);
        ret14.setChecked(dis.ret14);
        sub15.setChecked(dis.sub15);
        ret15.setChecked(dis.ret15);


        btnmod.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addPostList(ev1.getText().toString(), ev2.getText().toString()
                        ,sub1.isChecked(),sub2.isChecked(),sub3.isChecked(),sub4.isChecked(),sub5.isChecked(),sub6.isChecked(),sub7.isChecked(),sub8.isChecked(),sub9.isChecked(),sub10.isChecked(),sub11.isChecked(),sub12.isChecked(),sub13.isChecked(),sub14.isChecked(),sub15.isChecked()
                        , ret1.isChecked(), ret2.isChecked(), ret3.isChecked(), ret4.isChecked(), ret5.isChecked(), ret6.isChecked(), ret7.isChecked(), ret8.isChecked(), ret9.isChecked(), ret10.isChecked(), ret11.isChecked(), ret12.isChecked(), ret13.isChecked(), ret14.isChecked(), ret15.isChecked());
                DisinfectModifyActivity.super.onRestart();
                finish();
            }
        });

    }

    public void addPostList(String date, String disper, boolean sub1, boolean sub2, boolean sub3, boolean sub4, boolean sub5, boolean sub6, boolean sub7, boolean sub8, boolean sub9, boolean sub10, boolean sub11, boolean sub12, boolean sub13, boolean sub14, boolean sub15, boolean ret1, boolean ret2, boolean ret3, boolean ret4, boolean ret5, boolean ret6, boolean ret7, boolean ret8, boolean ret9, boolean ret10, boolean ret11, boolean ret12, boolean ret13, boolean ret14, boolean ret15){ // 새로운 과제 체크 리스트 만드는 것
        Disinfect dis = new Disinfect(date,disper
                ,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12,sub13,sub14,sub15
                , ret1,ret2,ret3,ret4,ret5,ret6,ret7,ret8,ret9,ret10,ret11,ret12,ret13,ret14,ret15);
        databaseReference.child("Disinfect").child(date).setValue(dis);

    }


}
