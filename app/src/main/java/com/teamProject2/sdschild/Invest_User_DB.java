package com.teamProject2.sdschild;

public class Invest_User_DB {
    private String std_name; //학생이름
    private String std_num; //교번 -primary key
    private int have_miso; //보유 미소
    private int have_num_invest; //보유 주식 수
    private float  average_invest_price; //평단가

    public Invest_User_DB(){}

    //이름
    public String getStd_name(){return std_name;}
    public void setStd_name(String std_name){this.std_name=std_name;}

    //교번
    public String getStd_num(){return std_num;}
    public void setStd_num(String std_num){this.std_num=std_num;}

    //보유미소
    public int getHave_miso(){return have_miso;}
    public void setHave_miso(int have_miso){this.have_miso=have_miso;}

    //보유 주식 수
    public int getHave_num_invest(){return have_num_invest;}
    public void setHave_num_invest(int have_num_invest){this.have_num_invest=have_num_invest;}

    //현재 평단가
    public float getAverage_invest_price(){return average_invest_price;}
    public void setAverage_invest_price(float average_invest_price){this.average_invest_price=average_invest_price;}


    public Invest_User_DB(String std_name, String std_num, int have_miso, int have_num_invest, float average_invest_price){
        this.std_name=std_name;
        this.std_num=std_num;
        this.have_miso=have_miso;
        this.have_num_invest=have_num_invest;
        this.average_invest_price=average_invest_price;
    }
}
