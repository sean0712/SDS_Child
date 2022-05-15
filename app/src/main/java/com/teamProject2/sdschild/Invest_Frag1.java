package com.teamProject2.sdschild;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/*

    ★★★    투자현황 화면   ★★★


 */


public class Invest_Frag1 extends Fragment {

    private View view;

    String std_num = "1"; //나중에 바꾸자

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Invest_DB_Control controler=new Invest_DB_Control();

    TextView have_miso_text;
    TextView have_invest_text;
    TextView num_invest_text;
    TextView average_price_text;
    TextView day_price_text;
    TextView calc;


    public static Invest_Frag1 newInstance() {
        Invest_Frag1 investfrag1 = new Invest_Frag1();
        return investfrag1;
    }



    /*
            프로그래밍으로 건드려야 할 부분

        ★★★findViewById 바로 못씀 -> 밑에 함수에선 view.findViewById로 해야됨★★★
        ★★★fragment에선 getWindow() 바로 못써서 getActivity().getWindow()로 사용해야됨★★★

    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_invest__frag1, container, false);


        /*--------------------보유 미소와 보유 주식수를 자동업데이트해 출력해주는 이벤트-------------------------------*/
        databaseReference.child("invest_std_information").child("1").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_User_DB std = dataSnapshot.getValue(Invest_User_DB.class);

                databaseReference.child("day_information").child(controler.Get_Time2()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Invest_Basic_DB basic_db=dataSnapshot.getValue(Invest_Basic_DB.class);

                        have_miso_text=view.findViewById(R.id.have_miso);
                        have_invest_text=view.findViewById(R.id.have_invest);
                        num_invest_text=view.findViewById(R.id.num_invest);
                        average_price_text=view.findViewById(R.id.average_price);
                        day_price_text=view.findViewById(R.id.day_price);
                        calc=view.findViewById(R.id.calc);


                        have_miso_text.setText("보유 미소 : "+String.valueOf(std.getHave_miso())+"미소");
                        have_invest_text.setText("보유 주식 수 : "+String.valueOf(std.getHave_num_invest())+"주");
                        num_invest_text.setText(String.valueOf(std.getHave_num_invest()));
                        average_price_text.setText(String.valueOf(std.getAverage_invest_price()));
                        day_price_text.setText(String.valueOf(basic_db.getDay_price()));

                        //손익 계산식
                        String resultCalc;
                        float reCalc= (basic_db.getDay_price()*std.getHave_num_invest())-(std.getAverage_invest_price()*std.getHave_num_invest());
                        if(reCalc>0){
                            resultCalc = "+"+String.valueOf(reCalc);
                        }
                        else{
                            resultCalc=String.valueOf(reCalc);
                        }
                        calc.setText(resultCalc);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        /*--------------------보유 미소와 보유 주식수를 자동업데이트해 출력해주는 이벤트-------------------------------*/

        return view;
    }
}