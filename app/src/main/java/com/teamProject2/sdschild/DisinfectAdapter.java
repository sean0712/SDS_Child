package com.teamProject2.sdschild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DisinfectAdapter  extends BaseAdapter {
    List<Disinfect> dis;
    Context context;
    LayoutInflater inflater;

    public DisinfectAdapter(List<Disinfect> f, Context context) {
        this.dis = f;
        this.context = context;
        this.inflater = (LayoutInflater) context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return dis.size();
    }

    @Override
    public Object getItem(int position) {
        return dis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(R.layout.activity_dis_item,null);
        }

        TextView item1 = (TextView)convertView.findViewById(R.id.dis_item1);
        TextView item2 = (TextView)convertView.findViewById(R.id.dis_item2);

        Disinfect f = dis.get(position);
        item1.setText(f.date);
        item2.setText(f.disper);

        return convertView;
    }
}
