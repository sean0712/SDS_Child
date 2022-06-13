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
import android.app.Dialog;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Invest_Frag0#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Invest_Frag0 extends Fragment {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    private View view;
    private LineChart chart;

    TextView buy_amount;
    TextView sell_amount;
    Dialog dialog;
    Context mContext;
    Invest_DB_Control controler = new Invest_DB_Control();
    TextView day_price_txt;
    TextView have_miso_txt;
    TextView have_invest_txt;


    ArrayList<Entry> values = new ArrayList<>();






    public static Invest_Frag0 newInstance(){
        Invest_Frag0 investfrag0 = new Invest_Frag0();
        return investfrag0;
    }

    /*
        ★★★    투자하기 화면   ★★★
    ★★★findViewById 바로 못씀 -> 밑에 함수에선 view.findViewById로 해야됨★★★
    ★★★fragment에선 getWindow() 바로 못써서 getActivity().getWindow()로 사용해야됨★★★
    */

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_invest__frag0, container, false);
        chart= view.findViewById(R.id.linechart);

        buy_amount = view.findViewById(R.id.day_amount_bought_text);
        sell_amount = view.findViewById(R.id.day_amount_sold_text);

        mContext= container.getContext();

        controler.GetContext(mContext);


        //차트설정
        databaseReference.child("day_information").limitToLast(10).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int i=0;
                   for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                       Invest_Basic_DB basic_db=snapshot.getValue(Invest_Basic_DB.class);
                       Log.i("test", String.valueOf(basic_db.getDay_price() +"/"+ String.valueOf(i)));
                       values.add(new Entry(i,(float)basic_db.getDay_price()));
                       i++;
                       if(i>10){break;}
                   }
                LineDataSet set1;
                set1 = new LineDataSet(values, "DataSet 1");

                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(set1); // add the data sets

                // create a data object with the data sets
                LineData data = new LineData(dataSets);
                // black lines and points
                set1.setColor(Color.BLACK);
                set1.setCircleColor(Color.BLACK);

                chart.notifyDataSetChanged();
                chart.invalidate();

                // set data
                chart.setData(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //테스트용 데이터 넣기
        view.findViewById(R.id.sampleBtn).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                controler.Add_Std_information("김동현", "1", 100, 10, 1);
                controler.Add_Std_information("최윤재", "2", 100, 10, 1);
                controler.Add_Std_information("염다빈", "3", 100, 10, 1);
                controler.Add_Std_information("이시안", "4", 100, 10, 1);
                controler.Add_Std_information("홍길동", "5", 100, 10, 1);

                controler.Add_basic_information(controler.Get_Time2(), 10, 0, 0);
            }
        });

        //매수량과 매도량의 변화가 있을 때 마다 update해서 화면에 출력해주는 코드
        databaseReference.child("day_information").child(controler.Get_Time2()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_Basic_DB basic_db = dataSnapshot.getValue(Invest_Basic_DB.class);
                int buy = basic_db.getDay_amount_bought();
                int sell = basic_db.getDay_amount_sold();

                buy_amount.setText(String.valueOf(buy));
                sell_amount.setText(String.valueOf(sell));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        view.findViewById(R.id.purchaseBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Show_Buy_Dialog();
            }
        });

        view.findViewById(R.id.sellBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Show_Sell_Dialog();
            }
        });
        return view;
    }

    //매수하기 다이어로그
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Show_Buy_Dialog(){
        dialog=new Dialog(mContext);
        dialog.requestWindowFeature(getActivity().getWindow().FEATURE_NO_TITLE);//fragment에선 getWindow바로 못써서 getActivity사용해야됨
        dialog.setContentView(R.layout.dialog_geolae);

        day_price_txt=dialog.findViewById(R.id.day_price);
        have_miso_txt=dialog.findViewById(R.id.have_miso);

        databaseReference.child("day_information").child(controler.Get_Time2()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_Basic_DB basic_db=dataSnapshot.getValue(Invest_Basic_DB.class);
                day_price_txt.setText("오늘 주식 가격 : "+String.valueOf(basic_db.getDay_price())+"미소");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.child("invest_std_information").child(User.stdNum).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_User_DB std=dataSnapshot.getValue(Invest_User_DB.class);
                have_miso_txt.setText("보유 미소 : "+String.valueOf(std.getHave_miso())+"미소");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dialog.show();


        dialog.findViewById(R.id.geolaeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText want_buy_amount_text;


                int want_buy_amount;
                //사용자의 입력을 받아 want_buy_amount에 저장
                want_buy_amount_text = dialog.findViewById(R.id.want_buy_amount);
                if(want_buy_amount_text.getText().toString().equals("")){
                    Toast.makeText(mContext.getApplicationContext(),"구입을 원하는 개수를 입력해주세요",Toast.LENGTH_SHORT).show();
                }
                else{
                    want_buy_amount = Integer.parseInt(want_buy_amount_text.getText().toString());
                    controler.Buy_Invest(want_buy_amount, User.stdNum);
                    dialog.dismiss();

                }
            }

        });
    }

    //매도하기 다이어로그
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Show_Sell_Dialog(){
        //다이얼로그
        dialog=new Dialog(mContext);
        dialog.requestWindowFeature(getActivity().getWindow().FEATURE_NO_TITLE);//fragment에선 getWindow바로 못써서 getActivity사용해야됨
        dialog.setContentView(R.layout.dialog_denounce);
        day_price_txt=dialog.findViewById(R.id.day_price);
        have_invest_txt=dialog.findViewById(R.id.dialog_have_invest);

        databaseReference.child("day_information").child(controler.Get_Time2()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_Basic_DB basic_db=dataSnapshot.getValue(Invest_Basic_DB.class);
                day_price_txt.setText("오늘 주식 가격 : "+String.valueOf(basic_db.getDay_price())+"미소");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.child("invest_std_information").child(User.stdNum).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_User_DB std=dataSnapshot.getValue(Invest_User_DB.class);
                have_invest_txt.setText("보유 주식 수 : "+String.valueOf(std.getHave_num_invest())+"개");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dialog.show();

        dialog.findViewById(R.id.denounceBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText want_sell_amount_text;
                int want_sell_amount;

                //사용자의 입력을 받아 want_sell_amount에 저장
                want_sell_amount_text = dialog.findViewById(R.id.want_sell_amount);
                if(want_sell_amount_text.getText().toString().equals("")){
                    Toast.makeText(mContext.getApplicationContext(),"판매를 원하는 개수를 입력해주세요",Toast.LENGTH_SHORT).show();
                }
                else{
                    want_sell_amount = Integer.parseInt(want_sell_amount_text.getText().toString());
                    controler.Sell_Invest(want_sell_amount,User.stdNum);
                    dialog.dismiss();

                }
            }

        });
    }




}