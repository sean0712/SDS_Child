package com.teamProject2.sdschild;
public class User {
    String id;
    String pw;
    static String job = "Revenue";

    public User(){}

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getPW() {
        return pw;
    }

    public void setPW(String pw) {
        this.pw = pw;
    }

    public User(String ID, String PW){
        this.id = ID;
        this.pw = PW;
    }
}
