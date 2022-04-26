package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RevenueActivity extends AppCompatActivity {

    Button BtnRecord;
    Button BtnPost;

    ListView listView;
    ListAdapter adapter;
    List<Revenue> revenues = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference revenueRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

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
                adapter.notifyDataSetChanged();
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
                startActivity(intent);
            }
        });

        BtnRecord = findViewById(R.id.BtnRecord);
        BtnPost = findViewById(R.id.BtnPost);

        BtnRecord.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RevenueAddActivity.class);
                startActivity(intent);
            }
        });

        BtnPost.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RevenueRegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            revenues.clear();
            for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                String key = snapshot.getKey();
                Revenue revenue = snapshot.getValue(Revenue.class);
                revenue.date = key;
                revenues.add(revenue);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}