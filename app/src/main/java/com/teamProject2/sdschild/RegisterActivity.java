package com.teamProject2.sdschild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Button BtnSubmit;
    EditText EditID, EditPW, EditName, EditNum, EditMail;
    String strID, strPW, strName, strNum, strMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditID = (EditText) findViewById(R.id.EditID);
        EditPW = (EditText) findViewById(R.id.EditPW);
        EditName = (EditText) findViewById(R.id.EditName);
        EditNum = (EditText) findViewById(R.id.EditNum);
        EditMail = (EditText) findViewById(R.id.EditMail);

        BtnSubmit = (Button) findViewById(R.id.BtnSubmit);

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strID = EditID.getText().toString();
                strPW = EditPW.getText().toString();
                strName = EditName.getText().toString();
                strNum = EditNum.getText().toString();
                strMail = EditMail.getText().toString();

                if (strID.trim().equals("") ||  strPW.trim().equals("") || strName.equals("") || strNum.equals("")) {
                    Toast.makeText(getApplicationContext(), "필수 사항(*표시)을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    addUserInfo(strID, strPW," " ,strName, strNum, strMail);
                    finish();
                }

            }
        });

//        btn = findViewById(R.id.btn);
//        edit1 = findViewById(R.id.edit1);
//        edit2 = findViewById(R.id.edit2);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addUser(edit1.getText().toString(),edit2.getText().toString());
//            }
//        });
    }

//    public void addUser(String id, String pw) {
//        User user = new User(id,pw);
//        databaseReference.child("zoo").child(id).setValue(user);
//    }

//    public User(String id, String pw, String job, String name, String stdNum){
//        this.id = id;
//        this.pw = pw;
//        this.job = job;
//        this.name = name;
//        this.stdNum = stdNum;
//    }

    public void addUserInfo(String id, String pw, String job, String name, String stdNum, String mail) {
        User user = new User(id, pw, job, name, stdNum, mail);
        databaseReference.child("User").child(id).setValue(user);
    }

//    public void addRevenue(String date, String history, String amount) {
//        Revenue revenue = new Revenue(date, history, amount);
//        databaseReference.child("revenue").child(date).setValue(revenue);
//    }
}