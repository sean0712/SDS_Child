package com.teamProject2.sdschild;

public class Invest_List_DB {

    private int trade_type; //거래구분
    private int trade_price; //거래가격
    private int trade_amount; //거래량
    private float trade_gain; //거래 손익
    private int trade_count; //오늘 몇번째 거래인지
    //private int total_trade_count; //오늘 총 거래는 몇번인지

    public Invest_List_DB(){}

    public int getTrade_price(){return trade_price;}
    public void setTrade_price(int trade_price){this.trade_price = trade_price;}

    public int getTrade_amount(){return trade_amount;}
    public void setTrade_amount(int trade_amount){this.trade_amount=trade_amount;}

    public int getTrade_type(){return trade_type;}
    public void setTrade_type(int trade_type){this.trade_type=trade_type;}

    public float getTrade_gain(){return trade_gain;}
    public void setTrade_gain(float trade_gain){this.trade_gain=trade_gain;}

    public int  getTrade_count(){return trade_count;}
    public void setTrade_count(int trade_count){this.trade_count=trade_count;}

    //public int getTotal_trade_count(){return total_trade_count;}
    //public void setTotal_trade_count(int total_trade_count){this.total_trade_count=total_trade_count;}

    public Invest_List_DB(int trade_type, int trade_price, int trade_amount, float trade_gain, int trade_count){
        this.trade_type=trade_type;
        this.trade_price=trade_price;
        this.trade_amount=trade_amount;
        this.trade_gain=trade_gain;
        this.trade_count=trade_count;
    }


}
