package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
    EditText EditSearch;

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
        EditSearch = findViewById(R.id.EditSearch);

        database = FirebaseDatabase.getInstance();

        boardRef = database.getReference("board");

        boardRef.addValueEventListener(postListener);

//        boardRef.child("board").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                boards.clear();
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Board board = snapshot.getValue(Board.class);
//                    boards.add(board);
//                }
//                listView.requestLayout();//
//                adapter.notifyDataSetChanged();
////                adapter.refreshAdapter((ArrayList<Revenue>) revenues);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                listView.requestLayout();// 1
//                adapter.notifyDataSetChanged(); // 1
//            }
//        });

        listView = findViewById(R.id.ListBoard);
        adapter = new BoardListAdapter(boards, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), BoardViewActivity.class);
                Object object = adapterView.getAdapter().getItem(i);
                intent.putExtra("board", (Board) object);
                startActivity(intent);
            }
        });

        BtnAll.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.search = " ";
                startActivity(getIntent());
                finish();
            }
        });

        BtnEducation.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.search = "학사";
                startActivity(getIntent());
                finish();
            }
        });

        BtnRevenue.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.search = "국세청";
                startActivity(getIntent());
                finish();
            }
        });

        BtnEvent.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.search = "행사";
                startActivity(getIntent());
                finish();
            }
        });

        EditSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                java.lang.System.out.println(keyCode);
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    System.search = EditSearch.getText().toString();
                    startActivity(getIntent());
                    finish();
                    return true;
                } else return false;
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
//1                    Board board = snapshot.getValue(Board.class);
//2                   board.title = key;
//3                   boards.add(board);
//                }
                if (key.contains(System.search)) {
                    Board board = snapshot.getValue(Board.class);
                    board.date = key;
                    boards.add(board);
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
