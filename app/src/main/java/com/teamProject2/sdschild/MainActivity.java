package com.teamProject2.sdschild;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button BtnLogin;
    Button BtnRegister;

    EditText EditID;
    EditText EditPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnLogin = findViewById(R.id.BtnLogin);
        BtnRegister = findViewById(R.id.BtnRegister);

        EditID = findViewById(R.id.EditID);
        EditPW = findViewById(R.id.EditPW);

//        BtnLogin.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                startActivity(intent);
//            }
//        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("User");

        BtnLogin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (EditID.toString().trim().equals("") ||  EditPW.toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "로그인 정보를 입력하세요.", Toast.LENGTH_LONG);
                }
                else {
                    ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("작업중...");
                    progressDialog.show();

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.child(EditID.getText().toString()).exists()) {
                                progressDialog.dismiss();
                                User user = dataSnapshot.child(EditID.getText().toString()).getValue(User.class);
                                if (user.getPw().equals(EditPW.getText().toString())) {
                                    Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_LONG);
                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    User.id = user.getId();
                                    User.pw = user.getPw();
                                    User.job = user.getJob();
                                    User.name = user.getName();
                                    User.stdNum = user.getStdNum();
                                    User.mail = user.getMail();
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG);
                                }
                            }
                            else {
                                Toast.makeText(MainActivity.this, "로그인 정보가 존재하지 않습니다.", Toast.LENGTH_LONG);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
//                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//                progressDialog.setMessage("작업중...");
//                progressDialog.show();
//
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if (dataSnapshot.child(EditID.getText().toString()).exists()) {
//                            progressDialog.dismiss();
//                            User user = dataSnapshot.child(EditID.getText().toString()).getValue(User.class);
//                            if (user.getPw().equals(EditPW.getText().toString())) {
//                                Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_LONG);
//                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                                User.id = user.getId();
//                                User.pw = user.getPw();
//                                User.job = user.getJob();
//                                User.name = user.getName();
//                                User.stdNum = user.getStdNum();
//                                User.mail = user.getMail();
//                                startActivity(intent);
//                                finish();
//                            }
//                            else {
//                                Toast.makeText(MainActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG);
//                            }
//                        }
//                        else {
//                            Toast.makeText(MainActivity.this, "로그인 정보가 존재하지 않습니다.", Toast.LENGTH_LONG);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });

//                String id = EditID.getText().toString();
//                String pw = EditPW.getText().toString();

//                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                startActivity(intent);
            }
        });

        BtnRegister.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}