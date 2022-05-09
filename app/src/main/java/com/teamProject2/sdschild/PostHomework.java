package com.teamProject2.sdschild;

public class PostHomework {
    String homework; // 과제명
    String date; // 마감 기한 날짜

    public PostHomework(String homework, String date) { // homework 클래스를 새로 만들까 고민 중
        this.homework = homework;
        this.date = date;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
