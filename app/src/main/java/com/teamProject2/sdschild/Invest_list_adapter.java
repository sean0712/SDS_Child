package com.teamProject2.sdschild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Invest_list_adapter extends BaseAdapter {

    Context mContext=null;
    LayoutInflater mLayoutInflater=null;
    ArrayList<Invest_List_DB> invest_list;

    public Invest_list_adapter(Context context, ArrayList<Invest_List_DB> data){
        this.mContext=context;
        this.invest_list=data;
        this.mLayoutInflater = LayoutInflater.from(mContext);

    }


    @Override
    public int getCount() {
        return invest_list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
       return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        View view=mLayoutInflater.inflate(R.layout.invest_list_item,null);
        String setText="";

        TextView trade_type_txt=(TextView)view.findViewById(R.id.trade_type_txt);
        TextView trade_price_txt=(TextView)view.findViewById(R.id.trade_price_txt);
        TextView trade_amount_txt=(TextView)view.findViewById(R.id.trade_amount_txt);
        TextView trade_gain_txt=(TextView)view.findViewById(R.id.trade_gain_txt);
        TextView trade_day_txt=view.findViewById(R.id.trade_day);

        if(invest_list.get(position)!=null) {
            if (invest_list.get(position).getTrade_type() == 0) {
                setText = "매수";
            } else {
                setText = "매도";
            }
        }

        trade_type_txt.setText(setText);
        trade_price_txt.setText("거래가격 : "+String.valueOf(invest_list.get(position).getTrade_price()));
        trade_amount_txt.setText("거래량 : "+String.valueOf(invest_list.get(position).getTrade_amount()));
        trade_gain_txt.setText("손/익 : "+String.format("%.2f",invest_list.get(position).getTrade_gain()));
        trade_day_txt.setText("거래날짜 : "+ invest_list.get(position).getTrade_day());

        return view;
    }


}
