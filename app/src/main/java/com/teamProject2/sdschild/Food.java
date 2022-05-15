package com.teamProject2.sdschild;

import java.io.Serializable;

public class Food implements Serializable {

    String date;
    String leader;

    String name1,name2,name3,name4,name5 ;
    String food1,food2,food3,food4,food5 ;
    String wf1,wf2,wf3,wf4,wf5;
    boolean check_Rev1,check_Rev2,check_Rev3,check_Rev4,check_Rev5 ; // 국세청 신고 여부

    public Food() {
    }

    public Food(String date, String leader
            , String name1, String name2, String name3, String name4, String name5
            , String food1, String food2, String food3, String food4, String food5
            , String wf1, String wf2, String wf3, String wf4, String wf5
            , boolean check_Rev1, boolean check_Rev2, boolean check_Rev3, boolean check_Rev4, boolean check_Rev5)
    {
        this.date = date;
        this.leader = leader;

        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;

        this.food1 = food1;
        this.food2 = food2;
        this.food3 = food3;
        this.food4 = food4;
        this.food5 = food5;

        this.wf1 = wf1;
        this.wf2 = wf2;
        this.wf3 = wf3;
        this.wf4 = wf4;
        this.wf5 = wf5;

        this.check_Rev1 = check_Rev1;
        this.check_Rev2 = check_Rev2;
        this.check_Rev3 = check_Rev3;
        this.check_Rev4 = check_Rev4;
        this.check_Rev5 = check_Rev5;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    public String getFood1() {
        return food1;
    }

    public void setFood1(String food1) {
        this.food1 = food1;
    }

    public String getFood2() {
        return food2;
    }

    public void setFood2(String food2) {
        this.food2 = food2;
    }

    public String getFood3() {
        return food3;
    }

    public void setFood3(String food3) {
        this.food3 = food3;
    }

    public String getFood4() {
        return food4;
    }

    public void setFood4(String food4) {
        this.food4 = food4;
    }

    public String getFood5() {
        return food5;
    }

    public void setFood5(String food5) {
        this.food5 = food5;
    }

    public String getWf1() {
        return wf1;
    }

    public void setWf1(String wf1) {
        this.wf1 = wf1;
    }

    public String getWf2() {
        return wf2;
    }

    public void setWf2(String wf2) {
        this.wf2 = wf2;
    }

    public String getWf3() {
        return wf3;
    }

    public void setWf3(String wf3) {
        this.wf3 = wf3;
    }

    public String getWf4() {
        return wf4;
    }

    public void setWf4(String wf4) {
        this.wf4 = wf4;
    }

    public String getWf5() {
        return wf5;
    }

    public void setWf5(String wf5) {
        this.wf5 = wf5;
    }

    public boolean isCheck_Rev1() {
        return check_Rev1;
    }

    public void setCheck_Rev1(boolean check_Rev1) {
        this.check_Rev1 = check_Rev1;
    }

    public boolean isCheck_Rev2() {
        return check_Rev2;
    }

    public void setCheck_Rev2(boolean check_Rev2) {
        this.check_Rev2 = check_Rev2;
    }

    public boolean isCheck_Rev3() {
        return check_Rev3;
    }

    public void setCheck_Rev3(boolean check_Rev3) {
        this.check_Rev3 = check_Rev3;
    }

    public boolean isCheck_Rev4() {
        return check_Rev4;
    }

    public void setCheck_Rev4(boolean check_Rev4) {
        this.check_Rev4 = check_Rev4;
    }

    public boolean isCheck_Rev5() {
        return check_Rev5;
    }

    public void setCheck_Rev5(boolean check_Rev5) {
        this.check_Rev5 = check_Rev5;
    }


}
