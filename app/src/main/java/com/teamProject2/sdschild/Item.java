// https://lktprogrammer.tistory.com/163

package com.teamProject2.sdschild;

import java.io.Serializable;

public class Item implements Serializable {

    String poster;
    String name;
    String amount;
    String count;

    public Item() {}

    public String getPoster() {
        return poster;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public String getCount() {
        return count;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Item(String poster, String name, String amount, String count) {
        this.poster = poster;
        this.name = name;
        this.amount = amount;
        this.count = count;
    }
}