package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class DisinfectActivity extends AppCompatActivity {

    Button BtnAdd ;

    ListView listView;
    DisinfectAdapter adapter;
    List<Disinfect> dis = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference DisRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disinfect);

        database = FirebaseDatabase.getInstance();
        DisRef = database.getReference("Disinfect");
        DisRef.addValueEventListener(postListener);

        listView = findViewById(R.id.DisListView);
        adapter = new DisinfectAdapter(dis,this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(getApplicationContext(), DisinfectModActivity.class);
                Object object = adapterView.getAdapter().getItem(i);
//                intent.putExtra("date", (Bundle) object);
                intent.putExtra("date", (Disinfect) object);
                startActivity(intent);
            }
        });

        BtnAdd = findViewById(R.id.add_DisDate); // 날짜 추가 버튼

        BtnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisinfectAddActivity.class);
                startActivity(intent);
            }
        });


    }



    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            dis.clear();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                String key = snapshot.getKey();
//                Revenue revenue = snapshot.getValue(Revenue.class);
//                revenue.date = key;
//                revenues.add(revenue);
//                if(key.contains(System.date)) {
                Disinfect item = snapshot.getValue(Disinfect.class);
                item.date = key;
                dis.add(item);
//                }
            }
            listView.requestLayout(); //
            adapter.notifyDataSetChanged(); //
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}
