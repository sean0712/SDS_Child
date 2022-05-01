package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
import java.util.List;

public class RevenueActivity extends AppCompatActivity {

    Button BtnRecord;
    Button BtnLeft, BtnRight;
    TextView TextDate;
    String time1;

    ListView listView;
    ListAdapter adapter;
    List<Revenue> revenues = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference revenueRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        TextDate = findViewById(R.id.TextDate);
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

        revenueRef.child("revenue").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                revenues.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Revenue revenue = snapshot.getValue(Revenue.class);
                    revenues.add(revenue);
                }
                listView.requestLayout();//
                adapter.notifyDataSetChanged();
//                adapter.refreshAdapter((ArrayList<Revenue>) revenues);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView = findViewById(R.id.ListRevenue);
        adapter = new ListAdapter(revenues, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), RevenueEditActivity.class);
                Object object = adapterView.getAdapter().getItem(i);
//                intent.putExtra("date", (Bundle) object);
                intent.putExtra("date", (Revenue) object);
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

//        BtnPost.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RevenueRegisterActivity.class);
//                startActivity(intent);
//            }
//        });
        BtnLeft = findViewById(R.id.BtnLeft);

        BtnLeft.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
                System.date = "2022-04";
//                startActivity(intent);
                finish();
                startActivity(getIntent());
            }
        });

        BtnRight = findViewById(R.id.BtnRight);

        BtnRight.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
                System.date = "2022-06";
//                startActivity(intent);
                finish();
                startActivity(getIntent());
            }
        });
    }

    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            revenues.clear();
            for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                String key = snapshot.getKey();
//                Revenue revenue = snapshot.getValue(Revenue.class);
//                revenue.date = key;
//                revenues.add(revenue);
                if(key.contains(System.date)) {
                    Revenue revenue = snapshot.getValue(Revenue.class);
                    revenue.date = key;
                    revenues.add(revenue);
                }
            }
            listView.requestLayout(); //
            adapter.notifyDataSetChanged(); //
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}