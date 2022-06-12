package com.teamProject2.sdschild;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    ImageButton BtnNotice;
    ImageButton BtnBoard;
    ImageButton BtnPhoto;
    ImageButton BtnCalendar;
    ImageButton BtnInvest;
    ImageButton BtnJob;
    ImageButton BtnMyPage;
    ImageButton BtnMarket;
    ImageButton BtnWeight;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BtnNotice = findViewById(R.id.BtnNotice);
        BtnBoard = findViewById(R.id.BtnBoard);
        BtnPhoto = findViewById(R.id.BtnPhoto);
        BtnCalendar = findViewById(R.id.BtnCalander);
        BtnInvest = findViewById(R.id.BtnInvest);
        BtnJob = findViewById(R.id.BtnJob);
        BtnMyPage = findViewById(R.id.BtnMyPage);
        BtnMarket = findViewById(R.id.BtnMarket);
        BtnWeight = findViewById(R.id.BtnWeight);

        Invest_DB_Control controler=new Invest_DB_Control();
        //하루에한번 주식 db 업데이트
        controler.Day_update();



        // 메소드를 control로 뺄 방법을 생각해보자..
        BtnInvest.setOnClickListener(new Button.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                databaseReference.child("day_information").child(controler.Get_Time2()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Invest_Basic_DB basic_db;
                        basic_db = dataSnapshot.getValue(Invest_Basic_DB.class);
                        if (basic_db.getDay_price() == 0) {
                            Toast.makeText(HomeActivity.this, "몸무게입력이 완료되지 않았습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent = new Intent(getApplicationContext(), InvestActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //하루에한번 basic db 생성
        databaseReference.child("day_information").child(controler.Get_Time2()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue(Invest_Basic_DB.class)==null){
                    controler.Add_basic_information(controler.Get_Time2(), 0, 0, 0); //이부분은 다른데로 빼야 할듯
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        BtnNotice.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
//                startActivity(intent);
                Intent url = new Intent(Intent.ACTION_VIEW);
                url.setData(Uri.parse("http://bitgoeul.gen.es.kr/mobile/config/mBoard.php?pid=26"));
                startActivity(url);
            }
        });

        BtnBoard.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

        BtnPhoto.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent url = new Intent(Intent.ACTION_VIEW);
                url.setData(Uri.parse("http://bitgoeul.gen.es.kr/mobile/config/mBoard.php?pid=10"));
                startActivity(url);
            }
        });

        BtnCalendar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
//                startActivity(intent);
                Intent url = new Intent(Intent.ACTION_VIEW);
                url.setData(Uri.parse("http://bitgoeul.gen.es.kr/mobile/config/mCalendar.php?pid=11"));
                startActivity(url);
            }
        });

        BtnInvest.setOnClickListener(new Button.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InvestActivity.class);
                startActivity(intent);

                //테스트용 데이터 넣기
                controler.Add_Std_information("김동현", "1", 100, 10, 1);
                controler.Add_Std_information("최윤재", "2", 100, 10, 1);
                controler.Add_Std_information("염다빈", "3", 100, 10, 1);
                controler.Add_Std_information("이시안", "4", 100, 10, 1);
                controler.Add_Std_information("홍길동", "5", 100, 10, 1);

                controler.Add_basic_information(controler.Get_Time2(), 10, 0, 0);
//                controler.Add_List_information(0,0,0,0,0,0);
            }
        });

        BtnJob.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User.job.equals("Revenue")) {
                    Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
                    startActivity(intent);
                }
                else if (User.job.equals("Wholesaler")) {
                    Intent intent = new Intent(getApplicationContext(), WholesalerActivity.class);
                    startActivity(intent);
                }
                else if (User.job.equals("Post")) {
                    Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                    startActivity(intent);
                }
                else if (User.job.equals("Food")) {
                    Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
                    startActivity(intent);
                }
                else if (User.job.equals("Disinfect")) {
                    Intent intent = new Intent(getApplicationContext(), DisinfectActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), JobActivity.class);
                    startActivity(intent);
                }
            }
        });

        BtnMarket.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MarketActivity.class);
                startActivity(intent);
            }
        });

        BtnMyPage.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), MyPageActivity.class);
//                startActivity(intent);
                final String[] jobs = new String[] {  "Revenue", "Wholesaler", "Post", "Food", "Disinfect"  };

                final int[] selectedIndex = {0};

                if (User.job.equals("Revenue")) {
                    selectedIndex[0] = 0;
                }
                else if (User.job.equals("Wholesaler")) {
                    selectedIndex[0] = 1;
                }
                else if (User.job.equals("Post")) {
                    selectedIndex[0] = 2;
                }
                else if (User.job.equals("Food")) {
                    selectedIndex[0] = 3;
                }
                else {
                    selectedIndex[0] = 4;
                }


                AlertDialog.Builder dlg = new AlertDialog.Builder(HomeActivity.this);
                dlg.setTitle("시연용 마이페이지");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setSingleChoiceItems(jobs, selectedIndex[0],
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex[0] = which;
                            }
                        });
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(HomeActivity.this, jobs[selectedIndex[0]], Toast.LENGTH_SHORT).show();
                                User.job = jobs[selectedIndex[0]];
                            }
                        });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        BtnWeight.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WeightActivity.class);
                startActivity(intent);
            }
        });

    }

//    btn_notice = findViewById(R.id.)
//    btn_board;
//    btn_photo;
//    btn_calendar;
//    btn_invest;
//    btn_job;
//    btn_my_page;
}