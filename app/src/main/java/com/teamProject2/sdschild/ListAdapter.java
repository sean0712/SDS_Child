package com.teamProject2.sdschild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    List<Revenue> revenues;
    Context context;
    LayoutInflater inflater;

    public ListAdapter(List<Revenue> revenues, Context context){
        this.revenues = revenues;
        this.context = context;
        this.inflater = (LayoutInflater) context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return revenues.size();
    }

    @Override
    public Object getItem(int position) {
        return revenues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
        TextView txtContent = (TextView)convertView.findViewById(R.id.txtContent);

        Revenue revenue = revenues.get(position);
        txtTitle.setText(revenue.date);
        txtContent.setText(revenue.amount);

        return convertView;
    }
}