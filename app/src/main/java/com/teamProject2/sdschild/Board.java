package com.teamProject2.sdschild;

public class Board {

    String date;
    String content;
    String amount;

    public Board(){};

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

    public Board(String date, String content, String amount) {
        this.date = date;
        this.content = content;
        this.amount = amount;
    }
}
