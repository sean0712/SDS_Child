package com.teamProject2.sdschild;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Invest_DB_Control {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Context context;
    public void GetContext(Context context){
        this.context=context;
    }


    //학생정보를 데이터베이스에 추가하는 메서드
    //후에 회원가입 버튼에 등록이 되어야함
    public void Add_Std_information(String std_name, String std_num, int have_miso, int have_invest, float average_invest){
        Invest_User_DB std=new Invest_User_DB(std_name,std_num, have_miso, have_invest,average_invest);
        databaseReference.child("invest_std_information").child(std_num).setValue(std);
    }


    //날짜를 기준으로 데이터베이스에 정보 추가하는 메서드
    public void Add_basic_information(String this_day, int day_price, int day_amount_bought, int day_amount_sold) {
        Invest_Basic_DB basicDb = new Invest_Basic_DB(this_day, day_price, day_amount_bought, day_amount_sold);

        //화면이 지정되면 onsuccess 리스너로 토스트 띄우기정도 하면딜듯
        databaseReference.child("day_information").child(this_day).setValue(basicDb);
    }

    //하루에 한번 리스트 날짜를 생성해놔야 add가 가능하기때문에
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Add_List_information(int trade_type, int trade_price, int trade_amount, float trade_gain, int trade_count, int total_trade_count){
        int zero=0;
        Invest_List_DB list_db=new Invest_List_DB(trade_type, trade_price, trade_amount,trade_gain,trade_count);
        databaseReference.child("invest_list").child("1").child(Get_Time2()).child("total_trade_count").setValue(zero);
    }


//    //현재시간을 스트링으로 포멧화해서 반환해줌 yyyy-mm-dd
//    public String Get_Time(){
//        long now= java.lang.System.currentTimeMillis();
//        Date mDate=new Date(now);
//        SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");
//        String getTime=simpleDate.format(mDate);
//        return getTime;
//    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String Get_Time2(){
        String this_time;
        this_time= LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        return this_time;
    }

    //매수하기 메서드(원하는 매수량, 학생번호)
    public void Buy_Invest(int want_buy_amount, String std_num){
        databaseReference.child("invest_std_information").child(User.stdNum).addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_User_DB std=dataSnapshot.getValue(Invest_User_DB.class);
                databaseReference.child("day_information").child(Get_Time2()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Invest_Basic_DB basic_db=dataSnapshot.getValue(Invest_Basic_DB.class);

                        int have_miso=std.getHave_miso();
                        int have_Invest=std.getHave_num_invest();
                        float average_invest=std.getAverage_invest_price();
                        int day_price=basic_db.getDay_price();
                        int buy_amount=basic_db.getDay_amount_bought();

                        if(have_miso<day_price*want_buy_amount){
                            Toast.makeText(context,"보유 미소가 부족합니다.",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            //값 수정
                            std.setHave_miso(have_miso - day_price * want_buy_amount);
                            std.setHave_num_invest(have_Invest + want_buy_amount);

                            //평단가 계산
                            float set1=have_Invest*average_invest;
                            float set2=want_buy_amount*day_price;
                            float set3=have_Invest+want_buy_amount;
                            std.setAverage_invest_price((set1+set2)/set3);

                            //거래기록 리스트 추가
                            Add_List(0, day_price, want_buy_amount, 0);

                            //거래량 증가
                            basic_db.setDay_amount_bought(buy_amount + want_buy_amount);

                            //데이터 베이스 업데이트
                            databaseReference.child("invest_std_information").child(std_num).setValue(std);
                            databaseReference.child("day_information").child(Get_Time2()).setValue(basic_db);
                            Toast.makeText(context,"매수가 완료되었습니다.",Toast.LENGTH_SHORT).show();
                        }
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
    }

    public void Sell_Invest(int want_sell_amount, String std_num){
        databaseReference.child("invest_std_information").child(std_num).addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Invest_User_DB std=dataSnapshot.getValue(Invest_User_DB.class);
                databaseReference.child("day_information").child(Get_Time2()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Invest_Basic_DB basic_db=dataSnapshot.getValue(Invest_Basic_DB.class);

                        int have_miso=std.getHave_miso();
                        int have_Invest=std.getHave_num_invest();
                        float average_invest=std.getAverage_invest_price();
                        int day_price=basic_db.getDay_price();
                        int sell_amount=basic_db.getDay_amount_sold();

                        if(have_Invest<want_sell_amount){
                            Toast.makeText(context,"보유 주식수가 부족합니다..",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            //값 수정
                            std.setHave_miso(have_miso + day_price * want_sell_amount);
                            std.setHave_num_invest(have_Invest - want_sell_amount);

                            //평단가 계산 - 매도의경우 남은 주식이 하나도없으면 평단가는 0 로만들고 나머지는 그대로
                            if(have_Invest-want_sell_amount==0){
                                std.setAverage_invest_price(0);
                            }

                            //손익계산
                            float gain_calc= ((day_price*want_sell_amount)-(average_invest*want_sell_amount));

                            // 여기에 리스트관련 작업해야함
                            Add_List(1, day_price, want_sell_amount, gain_calc);

                            //거래량 증가
                            basic_db.setDay_amount_sold(sell_amount + want_sell_amount);

                            //데이터 베이스 업데이트
                            databaseReference.child("invest_std_information").child(std_num).setValue(std);
                            databaseReference.child("day_information").child(Get_Time2()).setValue(basic_db);
                            Toast.makeText(context,"매도가 완료되었습니다.",Toast.LENGTH_SHORT).show();
                        }
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
    }


    //매수시 기록을 해주는 메서드
    //일단 홈에서 투자버튼을 누를시 바로 생성되도록
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Add_List(int trade_type, int trade_price, int trade_amount, float trade_gain){

        databaseReference.child("invest_list").child("1").child(Get_Time2()).child("total_trade_count").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int total_trade_count = dataSnapshot.getValue(Integer.class);
                total_trade_count++;
                databaseReference.child("invest_list").child("1").child(Get_Time2()).child("total_trade_count").setValue(total_trade_count);

                Invest_List_DB list_db = new Invest_List_DB(trade_type, trade_price, trade_amount, trade_gain,total_trade_count);
                String trade_count = String.valueOf(list_db.getTrade_count());
                databaseReference.child("invest_list").child("1").child(Get_Time2()).child(trade_count).setValue(list_db);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


//    //학생 객체를 데이터베이스에서 받아와 복사해 리턴하는 메서드
//    public Invest_User_DB Get_std_data(String std_num){
//        Invest_User_DB std=new Invest_User_DB();
//
//        databaseReference.child("invest_std_information").child(std_num).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Invest_User_DB std_copy=dataSnapshot.getValue(Invest_User_DB.class);
//                std.setHave_num_invest(std_copy.getHave_num_invest());
//                std.setHave_miso(std_copy.getHave_miso());
//                std.setAverage_invest_price(std_copy.getAverage_invest_price());
//                std.setStd_name(std_copy.getStd_name());
//                std.setStd_num(std_copy.getStd_num());
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        return std;
//    }
//
//
//    //기본데이터 객체를 데이터베이스에서 받아와 복사해 리턴하는 메서드
//    public Invest_Basic_DB Get_basic_data(String day){
//        Invest_Basic_DB basic_db=new Invest_Basic_DB();
//        databaseReference.child("day_information").child(day).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Invest_Basic_DB basic_db_copy=dataSnapshot.getValue(Invest_Basic_DB.class);
//                basic_db.setDay_amount_bought(basic_db_copy.getDay_amount_bought());
//                basic_db.setDay_amount_sold(basic_db_copy.getDay_amount_sold());
//                basic_db.setDay_price(basic_db_copy.getDay_price());
//                basic_db.setThis_day(day);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        return basic_db;
//    }
}
