package com.teamProject2.sdschild;

public class Invest_Basic_DB {
    String this_day; //금일날짜
    int day_price; //금일 주식 가격
    int day_amount_bought; //금일 매수량
    int day_amount_sold; //금일 매도량

    public Invest_Basic_DB(){}

    public int getDay_price(){return day_price;}
    public void setDay_price(int day_price){this.day_price=day_price;}

    public String getThis_day(){return this_day;}
    public void setThis_day(String this_day){this.this_day=this_day;}

    public int getDay_amount_bought(){return day_amount_bought;}
    public void setDay_amount_bought(int day_amount_bought){this.day_amount_bought=day_amount_bought;}

    public int getDay_amount_sold(){return day_amount_sold;}
    public void setDay_amount_sold(int day_amount_sold){this.day_amount_sold=day_amount_sold;}

    public Invest_Basic_DB(String tihs_day, int day_price, int day_amount_bought, int day_amount_sold){
        this.day_price=day_price;
        this.this_day=this_day;
        this.day_amount_bought=day_amount_bought;
        this.day_amount_sold=day_amount_sold;
    }
}
