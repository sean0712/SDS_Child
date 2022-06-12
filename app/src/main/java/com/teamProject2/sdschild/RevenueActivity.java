package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RevenueActivity extends AppCompatActivity {

    Button BtnRecord;
    Button BtnLeft, BtnRight;
    Button BtnAll, BtnIncome, BtnExpenditure;
    Button BtnPost;
    TextView TextDate;
    TextView TextAmount;

    ListView listView;
    RevenueListAdapter adapter;
    List<Revenue> revenues = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference revenueRef;

    Integer totalAmount;

//    @Override
//    protected void onStart() {
//        super.onStart();
//        listView.requestLayout(); //
//        adapter.notifyDataSetChanged(); //
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        listView.requestLayout(); //
//        adapter.notifyDataSetChanged(); //
//        startActivity(getIntent());
//        finish();
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
////        listView.requestLayout(); //
////        adapter.notifyDataSetChanged(); //
////        startActivity(getIntent());
////        finish();
//        adapter.refreshAdapter((ArrayList<Revenue>) revenues);
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.amount = 0;
        System.month = 6;
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        TextDate = findViewById(R.id.TextDate);
        TextAmount = findViewById(R.id.TextAmount);
        //
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        //
//        Date date = new Date();
//        time1 = simpleDateFormat.format(date);

//        Calendar calendar = Calendar.getInstance();
//        String time2 = simpleDateFormat.format(calendar.getTime());

        TextDate.setText(System.date);

        database = FirebaseDatabase.getInstance();

        revenueRef = database.getReference("revenue");

        revenueRef.addValueEventListener(postListener);

//        revenueRef.child("revenue").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                revenues.clear();
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Revenue revenue = snapshot.getValue(Revenue.class);
//                    revenues.add(revenue);
//                }
////                listView.requestLayout();//
//                adapter.notifyDataSetChanged();
//                adapter.refreshAdapter((ArrayList<Revenue>) revenues);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        listView = findViewById(R.id.ListRevenue);
        adapter = new RevenueListAdapter(revenues, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), RevenueEditActivity.class);
                Object object = adapterView.getAdapter().getItem(i);
//                intent.putExtra("date", (Bundle) object);
                intent.putExtra("date", (Revenue) object);
                System.amount = totalAmount;
                startActivity(intent);
            }
        });

        BtnRecord = findViewById(R.id.BtnRecord);
//        BtnPost = findViewById(R.id.BtnPost);

        BtnRecord.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RevenueAddActivity.class);
                startActivity(intent);
            }
        });

        BtnPost = findViewById(R.id.BtnPost);

//        BtnPost.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(getApplicationContext(), RevenueRegisterActivity.class);
////
////                startActivity(intent);
//                Intent intent = new Intent(getApplicationContext(), RevenueRegisterActivity.class);
//                intent.putExtra("date", revenue);
//                startActivity(intent);
//            }
//        });

        BtnLeft = findViewById(R.id.BtnLeft);

        BtnLeft.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-");
                Date date = new Date();
                String time1 = simpleDateFormat.format(date);
                if (System.month != 1) {
                    System.month--;
                    time1 = time1 + "0" + System.month;
                    System.date = time1;
//                startActivity(intent);
//                finish();
                    Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
//                    startActivity(getIntent());
                    intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"기록이 없습니다", Toast.LENGTH_SHORT).show();
                }

            }
        });

        BtnRight = findViewById(R.id.BtnRight);

        BtnRight.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-");
                Date date = new Date();
                String time1 = simpleDateFormat.format(date);
                if (System.month != 6) {
                    System.month++;
                    time1 = time1 + "0" + System.month;
                    System.date = time1;
//                startActivity(intent);
//                finish();
                    Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
//                    startActivity(getIntent());
                    intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"기록이 없습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BtnAll = findViewById(R.id.BtnAll);
        BtnAll.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.amount = 0;
                Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
//                    startActivity(getIntent());
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        });

        BtnIncome = findViewById(R.id.BtnIncome);
        BtnIncome.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.amount = 1;
                Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
//                    startActivity(getIntent());
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        });


        BtnExpenditure = findViewById(R.id.BtnExpenditure);
        BtnExpenditure.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.amount = -1;
                Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
//                    startActivity(getIntent());
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        });
    }

    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            revenues.clear();
            totalAmount = 0;
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                String key = snapshot.getKey();
//                Revenue revenue = snapshot.getValue(Revenue.class);
//                revenue.date = key;
//                revenues.add(revenue);
                if (key.contains(System.date)) {
                    Revenue revenue = snapshot.getValue(Revenue.class); //
//                    if(Integer.parseInt(revenue.amount))
                    if (System.amount == 0) {
                        revenue.date = key;
                        revenues.add(revenue);

                        totalAmount = totalAmount + Integer.parseInt(revenue.amount);
                    }
                    else if (System.amount == 1) {
                        if(Integer.parseInt(revenue.amount) > 0) {
                            revenue.date = key;
                            revenues.add(revenue);
                            totalAmount = totalAmount + Integer.parseInt(revenue.amount);
                        }
                    }
                    else if (System.amount == -1) {
                        if(Integer.parseInt(revenue.amount) < 0) {
                            revenue.date = key;
                            revenues.add(revenue);
                            totalAmount = totalAmount + Integer.parseInt(revenue.amount);
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"범위가 벗어났습니다",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            TextAmount.setText(System.month + "월 변동량: " + totalAmount + "미소");

//            listView.requestLayout(); //
            adapter.notifyDataSetChanged(); //
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}