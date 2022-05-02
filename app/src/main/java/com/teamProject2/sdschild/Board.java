package com.teamProject2.sdschild;

import java.io.Serializable;

public class Board implements Serializable {

    String id;
    String author;
    String type;
    String content;
    String date;

    public Board(){};

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Board(String id, String author, String type, String content, String date) {
        this.id = id;
        this.author = author;
        this.type = type;
        this.content = content;
        this.date = date;
    }
}