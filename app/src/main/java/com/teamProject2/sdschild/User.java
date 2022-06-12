package com.teamProject2.sdschild;
public class User {
    //    String id;
//    String pw;
    static String id;
    static String pw;
    static String job = "Wholesaler"; // 관리자: job
    static String name = "김명지";
    static String stdNum = "1";
    static String mail;
    public User(){}


    public String getId() {
        return id;
    }

    public  String getPw() {
        return pw;
    }

    public  String getJob() {
        return job;
    }

    public  String getName() {
        return name;
    }

    public  String getStdNum() {
        return stdNum;
    }

    public  String getMail() {
        return mail;
    }

    public  void setId(String id) {
        User.id = id;
    }
    public  void setMail(String mail) {
        User.mail = mail;
    }

    //    public User(String ID, String PW){
//        this.id = ID;
//        this.pw = PW;
//    }

    public User(String id, String pw, String job, String name, String stdNum, String mail){
        this.id = id;
        this.pw = pw;
        this.job = job;
        this.name = name;
        this.stdNum = stdNum;
        this.mail = mail;
    }
}
