package com.teamProject2.sdschild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PostMainAdapter extends BaseAdapter {
    List<PostHomework> posthomework;
    Context context;
    LayoutInflater inflater;

    public PostMainAdapter(List<PostHomework> posthomework, Context context) {
        this.posthomework = posthomework;
        this.context = context;
        this.inflater = (LayoutInflater) context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return posthomework.size();
    }

    @Override
    public Object getItem(int position) {
        return posthomework.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(R.layout.activity_job_post_homework_item,null);
        }

        TextView homework = (TextView)convertView.findViewById(R.id.mli_homework);
        TextView deadline = (TextView)convertView.findViewById(R.id.mli_deadline);

        PostHomework post = posthomework.get(position);
        homework.setText(post.homework);
        deadline.setText(post.date);

        return convertView;
    }
}
