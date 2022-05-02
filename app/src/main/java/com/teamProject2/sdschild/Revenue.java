package com.teamProject2.sdschild;

import java.io.Serializable;

public class Revenue implements Serializable {

    // String id;
    String date;
    String content;
    String amount;

    public Revenue(){};

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

    public Revenue(String date, String content, String amount) {
        this.date = date;
        this.content = content;
        this.amount = amount;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("날짜: ");
//        sb.append(getDate()).append("\n");
//        sb.append("내역: ");
//        sb.append(getContent()).append("\n");
//        sb.append("금액: ").append(getAmount());
//        return sb.toString();
//    }
}
