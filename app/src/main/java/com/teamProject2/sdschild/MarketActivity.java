package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class MarketActivity extends AppCompatActivity {

    ListView listView;
    ItemListAdapter adapter;
    List<Item> items = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference marketRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        database = FirebaseDatabase.getInstance();

        marketRef = database.getReference("market");

        marketRef.addValueEventListener(postListener);

//        marketRef.child("market").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                items.clear();
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Item item = snapshot.getValue(Item.class);
//                    items.add(item);
//                }
//                listView.requestLayout();//
//                adapter.notifyDataSetChanged();
////                adapter.refreshAdapter((ArrayList<Revenue>) revenues);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        listView = findViewById(R.id.ListItem);
        adapter = new ItemListAdapter(items, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), WholesalerEditActivity.class);
                Object object = adapterView.getAdapter().getItem(i);
                intent.putExtra("item", (Item) object);
                startActivity(intent);
            }
        });

    }

    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            items.clear();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                String key = snapshot.getKey();
//                Revenue revenue = snapshot.getValue(Revenue.class);
//                revenue.date = key;
//                revenues.add(revenue);
//                if(key.contains(System.date)) {
                Item item = snapshot.getValue(Item.class);
                item.name = key;
                items.add(item);
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
