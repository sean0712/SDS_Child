package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FoodModifyActivity extends AppCompatActivity {

    Button BtnAdd,BtnDel;
    TextView etDate, etLeader;
    EditText eF1,eF2,eF3,eF4,eF5;
    EditText eN1,eN2,eN3,eN4,eN5;
    EditText eW1,eW2,eW3,eW4,eW5;
    CheckBox sub1,sub2,sub3,sub4,sub5;


    // 파이어베이스 연결 위해 사용
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_modify);

        Intent intent = getIntent();
        Food food = (Food) intent.getSerializableExtra("date");

        BtnAdd = findViewById(R.id.btn_modifyFood);
        BtnDel = findViewById(R.id.food_del);

        // 할당 및 값 설정
        etDate = findViewById(R.id.food_sel_date);
        etLeader=findViewById(R.id.food_sel_team);
        etDate.setText(food.date);
        etLeader.setText(food.leader);

        eF1 = findViewById(R.id.mf_tv5);
        eF2 = findViewById(R.id.mf_tv7);
        eF3 = findViewById(R.id.mf_tv9);
        eF4 = findViewById(R.id.mf_tv11);
        eF5 = findViewById(R.id.mf_tv13);
        eF1.setText(food.food1);
        eF2.setText(food.food2);
        eF3.setText(food.food3);
        eF4.setText(food.food4);
        eF5.setText(food.food5);


        eN1 = findViewById(R.id.mf_tv6);
        eN2 = findViewById(R.id.mf_tv8);
        eN3 = findViewById(R.id.mf_tv10);
        eN4 = findViewById(R.id.mf_tv12);
        eN5 = findViewById(R.id.mf_tv14);
        eN1.setText(food.name1);
        eN2.setText(food.name2);
        eN3.setText(food.name3);
        eN4.setText(food.name4);
        eN5.setText(food.name5);


        eW1 = findViewById(R.id.mf_cb5);
        eW2 = findViewById(R.id.mf_cb7);
        eW3 = findViewById(R.id.mf_cb9);
        eW4 = findViewById(R.id.mf_cb11);
        eW5 = findViewById(R.id.mf_cb13);
        eW1.setText(food.wf1);
        eW2.setText(food.wf2);
        eW3.setText(food.wf3);
        eW4.setText(food.wf4);
        eW5.setText(food.wf5);


        sub1 = findViewById(R.id.mf_cb6);
        sub2 = findViewById(R.id.mf_cb8);
        sub3 = findViewById(R.id.mf_cb10);
        sub4 = findViewById(R.id.mf_cb12);
        sub5 = findViewById(R.id.mf_cb14);
        sub1.setChecked(food.check_Rev1);
        sub2.setChecked(food.check_Rev2);
        sub3.setChecked(food.check_Rev3);
        sub4.setChecked(food.check_Rev4);
        sub5.setChecked(food.check_Rev5);

        BtnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addPostList(etDate.getText().toString(), etLeader.getText().toString()
                        ,eF1.getText().toString(),eF2.getText().toString(),eF3.getText().toString(),eF4.getText().toString(),eF5.getText().toString()
                        ,eN1.getText().toString(),eN2.getText().toString(),eN3.getText().toString(),eN4.getText().toString(),eN5.getText().toString()
                        ,eW1.getText().toString(),eW2.getText().toString(),eW3.getText().toString(),eW4.getText().toString(),eW5.getText().toString()
                        ,sub1.isChecked(),sub2.isChecked(),sub3.isChecked(),sub4.isChecked(),sub5.isChecked());
                FoodModifyActivity.super.onRestart();
                finish();
            }
        });


        BtnDel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                delPostList(etDate.getText().toString(), etLeader.getText().toString()
                        ,eF1.getText().toString(),eF2.getText().toString(),eF3.getText().toString(),eF4.getText().toString(),eF5.getText().toString()
                        ,eN1.getText().toString(),eN2.getText().toString(),eN3.getText().toString(),eN4.getText().toString(),eN5.getText().toString()
                        ,eW1.getText().toString(),eW2.getText().toString(),eW3.getText().toString(),eW4.getText().toString(),eW5.getText().toString()
                        ,sub1.isChecked(),sub2.isChecked(),sub3.isChecked(),sub4.isChecked(),sub5.isChecked());
                FoodModifyActivity.super.onRestart();
                finish();
            }
        });


    }

    public void addPostList(String date, String leader, String f1, String f2, String f3, String f4, String f5, String N1, String N2, String N3, String N4, String N5
            , String W1, String W2, String W3, String W4, String W5 ,boolean sub1, boolean sub2
            , boolean sub3, boolean sub4, boolean sub5){ // 새로운 과제 체크 리스트 만드는 것
        Food food = new Food(date,leader,f1,f2,f3,f4,f5,N1,N2,N3,N4,N5,W1,W2,W3,W4,W5,sub1,sub2,sub3,sub4,sub5);
        databaseReference.child("Food").child(date).setValue(food);

    }

    public void delPostList(String date, String leader, String f1, String f2, String f3, String f4, String f5, String N1, String N2, String N3, String N4, String N5
            , String W1, String W2, String W3, String W4, String W5 ,boolean sub1, boolean sub2
            , boolean sub3, boolean sub4, boolean sub5){ // 새로운 과제 체크 리스트 만드는 것
        Food food = new Food(date,leader,f1,f2,f3,f4,f5,N1,N2,N3,N4,N5,W1,W2,W3,W4,W5,sub1,sub2,sub3,sub4,sub5);
        databaseReference.child("Food").child(date).setValue(null);

    }
}

