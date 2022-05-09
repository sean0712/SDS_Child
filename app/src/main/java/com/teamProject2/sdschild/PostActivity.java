package com.teamProject2.sdschild;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    Button BtnAdd ;
    Button BtnSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_post);

        BtnAdd = findViewById(R.id.btn_addPost);
        BtnSelect = findViewById(R.id.btn_selPost);

        BtnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostAddActivity.class);
                startActivity(intent);
            }
        });

        BtnSelect.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostSelectActivity.class);
                startActivity(intent);
            }
        });


        // 리사이클뷰 연결 및 임시 데이터 입력
        RecyclerView recyclerView = findViewById(R.id.post_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        PostAdapter adapter = new PostAdapter();
        adapter.addItem(new Post("4", "김동현",true,true));
        adapter.addItem(new Post("1", "최윤재",true,true));
        adapter.addItem(new Post("2", "이시안",true,true));
        adapter.addItem(new Post("3", "염다빈",true,true));

        adapter.addItem(new Post("4", "김동현",true,true));
        adapter.addItem(new Post("1", "최윤재",true,true));
        adapter.addItem(new Post("2", "이시안",true,true));
        adapter.addItem(new Post("3", "염다빈",true,true));

        adapter.addItem(new Post("4", "김동현",true,true));
        adapter.addItem(new Post("1", "최윤재",true,true));
        adapter.addItem(new Post("2", "이시안",true,true));
        adapter.addItem(new Post("3", "염다빈",true,true));


        adapter.addItem(new Post("4", "김동현",true,true));
        adapter.addItem(new Post("1", "최윤재",true,true));
        adapter.addItem(new Post("2", "이시안",true,true));
        adapter.addItem(new Post("3", "염다빈",true,true));

        recyclerView.setAdapter(adapter);
        // 리싸이클 뷰 관련 끝 ~
    }
}
