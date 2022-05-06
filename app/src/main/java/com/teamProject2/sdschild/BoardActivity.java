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

public class BoardActivity extends AppCompatActivity {

    Button BtnAll, BtnEducation, BtnRevenue, BtnEvent;

    //
    ListView listView;
    BoardListAdapter adapter;
    List<Board> boards = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference boardRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        BtnAll = findViewById(R.id.BtnAll);
        BtnEducation = findViewById(R.id.BtnEducation);
        BtnRevenue = findViewById(R.id.BtnRevenue);
        BtnEvent = findViewById(R.id.BtnEvent);

        database = FirebaseDatabase.getInstance();

        boardRef = database.getReference("board");

        boardRef.addValueEventListener(postListener);

        boardRef.child("board").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boards.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Board board = snapshot.getValue(Board.class);
                    boards.add(board);
                }
                listView.requestLayout();//
                adapter.notifyDataSetChanged();
//                adapter.refreshAdapter((ArrayList<Revenue>) revenues);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView = findViewById(R.id.ListBoard);
        adapter = new BoardListAdapter(boards, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), RevenueEditActivity.class);
                Object object = adapterView.getAdapter().getItem(i);
                intent.putExtra("date", (Revenue) object);
                startActivity(intent);
            }
        });

    }

    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            boards.clear();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                String key = snapshot.getKey();
//                Revenue revenue = snapshot.getValue(Revenue.class);
//                revenue.date = key;
//                revenues.add(revenue);
//                if(key.contains(System.date)) {
                    Board board = snapshot.getValue(Board.class);
                    board.title = key;
                    boards.add(board);
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
