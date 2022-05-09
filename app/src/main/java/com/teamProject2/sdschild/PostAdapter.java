package com.teamProject2.sdschild;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    ArrayList<Post> items = new ArrayList<Post>();


    FirebaseDatabase database;
    DatabaseReference revenueRef;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.activity_job_post_item_list, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Post item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Post item) {
        items.add(item);
    }

    public void setItems(ArrayList<Post> items) {
        this.items = items;
    }

    public Post getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Post item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        CheckBox checkBox1;
        CheckBox checkBox2;


        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.piltv1);
            textView2 = itemView.findViewById(R.id.piltv2);
            checkBox1 = itemView.findViewById(R.id.pilcb1);
            checkBox2 = itemView.findViewById(R.id.pilcb2);
        }

        public void setItem(Post item) {
            textView.setText(item.getStu_num());
            textView2.setText(item.getStu_name());
            checkBox1.setChecked(item.isStu_submit());
            checkBox2.setChecked(item.isStu_return());
        }

    }

}
