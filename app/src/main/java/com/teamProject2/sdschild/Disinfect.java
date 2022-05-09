package com.teamProject2.sdschild;

public class Disinfect {

    String date;
    String content;
    String amount;

    public Disinfect(){};

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getAmount() {
        return amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Disinfect(String date, String content, String amount) {
        this.date = date;
        this.content = content;
        this.amount = amount;
    }
}
