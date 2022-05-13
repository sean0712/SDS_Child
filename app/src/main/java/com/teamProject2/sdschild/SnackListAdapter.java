package com.teamProject2.sdschild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SnackListAdapter extends BaseAdapter {
    List<Item> items;
    Context context;
    LayoutInflater inflater;

    public SnackListAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.snack_list_item, null);
        }



        TextView txtTitle = (TextView) convertView.findViewById(R.id.TextTitle);
//        TextView txtContent = (TextView) convertView.findViewById(R.id.txtContent);

        Item item = items.get(position);

        txtTitle.setText(item.name);
//        txtContent.setText(item.amount);

        return convertView;
    }
}