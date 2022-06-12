package com.teamProject2.sdschild;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WeightActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        Invest_DB_Control controler=new Invest_DB_Control();
        Button weight_setBtn;
        EditText weight_valuetxt;

        weight_setBtn=findViewById(R.id.weight_setBtn);
        weight_valuetxt=findViewById(R.id.weight_valuetxt);

        weight_setBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                //오늘 몸무게값이 0이여야 입력이가능하고 다른 값이있다면 이미 설정되어 수정이불가능함을 알림
                databaseReference.child("day_information").child(controler.Get_Time2()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Invest_Basic_DB basic_db=dataSnapshot.getValue(Invest_Basic_DB.class);
                        if(basic_db.getDay_price()==0){
                            if(weight_valuetxt.getText().toString()=="" || weight_valuetxt.getText().toString()=="0") {
                                Toast.makeText(WeightActivity.this, "몸무게를 입력해주세요", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("day_information").child(controler.Get_Time2()).child("day_price").setValue(Integer.valueOf(weight_valuetxt.getText().toString()));
                                Toast.makeText(WeightActivity.this, "등록이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                        else{
                            Toast.makeText(WeightActivity.this, "오늘의 몸무게 설정이 이미 완료되었습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
