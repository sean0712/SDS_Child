package com.teamProject2.sdschild;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*

    ★★★    투자현황 화면   ★★★


 */


public class Invest_Frag1 extends Fragment {

    private View view;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Invest_DB_Control controler=new Invest_DB_Control();

    //거래기록에 사용
    ArrayList<Invest_List_DB> invest_list=new ArrayList<Invest_List_DB>();
    ListView listView;
    Invest_list_adapter adapter;


    TextView have_miso_text;
    TextView have_invest_text;
    TextView num_invest_text;
    TextView average_price_text;
    TextView day_price_text;
    TextView calc;
    Context mContext;



    public static Invest_Frag1 newInstance() {
        Invest_Frag1 investfrag1 = new Invest_Frag1();
        return investfrag1;
    }



    /*
            프로그래밍으로 건드려야 할 부분

        ★★★findViewById 바로 못씀 -> 밑에 함수에선 view.findViewById로 해야됨★★★
        ★★★fragment에선 getWindow() 바로 못써서 getActivity().getWindow()로 사용해야됨★★★

    */

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_invest__frag1, container, false);
        mContext= container.getContext();

        adapter=new Invest_list_adapter(mContext, invest_list);
        listView=(ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        RadioGroup day_type=view.findViewById(R.id.day_type);

        /*--------------------보유 미소와 보유 주식수를 자동업데이트해 출력해주는 이벤트-------------------------------*/
        databaseReference.child("invest_std_information").child(User.stdNum).addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_User_DB std = dataSnapshot.getValue(Invest_User_DB.class);

                databaseReference.child("day_information").child(controler.Get_Time2()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Invest_Basic_DB basic_db = dataSnapshot.getValue(Invest_Basic_DB.class);

                        have_miso_text = view.findViewById(R.id.have_miso);
                        have_invest_text = view.findViewById(R.id.have_invest);
                        num_invest_text = view.findViewById(R.id.num_invest);
                        average_price_text = view.findViewById(R.id.average_price);
                        day_price_text = view.findViewById(R.id.day_price);
                        calc = view.findViewById(R.id.calc);


                        have_miso_text.setText("보유 미소 : " + String.valueOf(std.getHave_miso()) + "미소");
                        have_invest_text.setText("보유 주식 수 : " + String.valueOf(std.getHave_num_invest()) + "주");
                        num_invest_text.setText(String.valueOf(std.getHave_num_invest()));
                        average_price_text.setText(String.format("%.2f",std.getAverage_invest_price()));
                        day_price_text.setText(String.valueOf(basic_db.getDay_price()));

                        //손익 계산식
                        String resultCalc;
                        float reCalc = (basic_db.getDay_price() * std.getHave_num_invest()) - (std.getAverage_invest_price() * std.getHave_num_invest());
                        if (reCalc > 0) {
                            resultCalc = "+" + String.format("%.2f",reCalc);
                        } else {
                            resultCalc = String.format("%.2f",reCalc);
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


        //라디오 버튼 체크에따라 거래기록 출력
        day_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId==R.id.rg_oneday){
                    Initializeinvestdata(0);
                }
                else if(checkedId==R.id.rg_week){
                        Initializeinvestdata(7);
                }
                else if(checkedId == R.id.rg_month) {
                    Initializeinvestdata(30);
                }

            }
        });

        return view;
    }
    /*--------------------거래기록에 대한 코드-------------------------------*/


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Initializeinvestdata(int i){
        //일주일의 경우
        for(int minus_day=0; minus_day<=i; minus_day++){

            LocalDateTime Dday=LocalDateTime.now();
            LocalDateTime control_day=Dday.minusDays(minus_day);

            String day_string=control_day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


            databaseReference.child("invest_list").child(User.stdNum).child(day_string).child("total_trade_count").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    invest_list.clear();
                    if(dataSnapshot.getValue(Integer.class)==null){
                        Log.i("test", "Initializeinvestdata: null");
                    }
                    else if(dataSnapshot.getValue(Integer.class)==0){
                        invest_list.clear();
                        adapter.notifyDataSetChanged();
                    }
                    else{
                        int total_count=dataSnapshot.getValue(Integer.class);
                        for(int a=1; a<=total_count; a++){
                            String count=String.valueOf(a);
                            databaseReference.child("invest_list").child(User.stdNum).child(day_string).child(count).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Invest_List_DB item=dataSnapshot.getValue(Invest_List_DB.class);
                                    invest_list.add(item);
                                    adapter.notifyDataSetChanged();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });

        }
    }
}