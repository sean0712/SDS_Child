package com.teamProject2.sdschild;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostSelectAdapter  extends RecyclerView.Adapter<PostSelectAdapter.ViewHolder>  {
    ArrayList<PostHomework> items = new ArrayList<PostHomework>();

    @NonNull
    @Override
    public PostSelectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.activity_job_post_recycle_item, viewGroup, false);

        return new PostSelectAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostSelectAdapter.ViewHolder viewHolder, int position) {
        PostHomework item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(PostHomework item) {
        items.add(item);
    }

    public void setItems(ArrayList<PostHomework> items) {
        this.items = items;
    }

    public PostHomework getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, PostHomework item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.post_seltv1);
            textView2 = itemView.findViewById(R.id.post_seltv2);
        }

        public void setItem(PostHomework item) {
            textView.setText(item.getHomework());
            textView2.setText(item.getDate());
        }

    }
}
