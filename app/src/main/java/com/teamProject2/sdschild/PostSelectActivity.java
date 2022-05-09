package com.teamProject2.sdschild;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PostSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_post_select);

        //리싸이클 뷰 연결
        RecyclerView recyclerView = findViewById(R.id.post_sel_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        PostSelectAdapter adapter = new PostSelectAdapter();
        adapter.addItem(new PostHomework("국어","20220507"));
        adapter.addItem(new PostHomework("수학","20220507"));
        adapter.addItem(new PostHomework("영어","20220507"));
        adapter.addItem(new PostHomework("과학","20220507"));
        adapter.addItem(new PostHomework("국어","20220507"));
        adapter.addItem(new PostHomework("수학","20220507"));
        adapter.addItem(new PostHomework("영어","20220507"));
        adapter.addItem(new PostHomework("과학","20220507"));

        adapter.addItem(new PostHomework("국어","20220507"));
        adapter.addItem(new PostHomework("수학","20220507"));
        adapter.addItem(new PostHomework("영어","20220507"));
        adapter.addItem(new PostHomework("과학","20220507"));

        adapter.addItem(new PostHomework("국어","20220507"));
        adapter.addItem(new PostHomework("수학","20220507"));
        adapter.addItem(new PostHomework("영어","20220507"));
        adapter.addItem(new PostHomework("과학","20220507"));

        recyclerView.setAdapter(adapter);

    }
}
