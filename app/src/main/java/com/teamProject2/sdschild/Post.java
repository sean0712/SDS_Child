package com.teamProject2.sdschild;

public class Post {

    String stu_num; // 출석번호
    String stu_name; // 이름
    boolean stu_submit; // 제출 여부
    boolean stu_return; // 반환 여부

    public Post(String stu_num, String stu_name, boolean stu_submit, boolean stu_return) {
        this.stu_num = stu_num;
        this.stu_name = stu_name;
        this.stu_submit = stu_submit;
        this.stu_return = stu_return;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public boolean isStu_submit() {
        return stu_submit;
    }

    public void setStu_submit(boolean stu_submit) {
        this.stu_submit = stu_submit;
    }

    public boolean isStu_return() {
        return stu_return;
    }

    public void setStu_return(boolean stu_return) {
        this.stu_return = stu_return;
    }



}
