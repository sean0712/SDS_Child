package com.teamProject2.sdschild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FoodMainAdapter extends BaseAdapter {
    List<Food> food;
    Context context;
    LayoutInflater inflater;

    public FoodMainAdapter(List<Food> f, Context context) {
        this.food = f;
        this.context = context;
        this.inflater = (LayoutInflater) context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return food.size();
    }

    @Override
    public Object getItem(int position) {
        return food.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(R.layout.activity_food_main_item,null);
        }

        TextView date = (TextView)convertView.findViewById(R.id.item_Date);
        TextView leader = (TextView)convertView.findViewById(R.id.item_team);

       Food f = food.get(position);
        date.setText(f.date);
        leader.setText(f.leader);

        return convertView;
    }
}
