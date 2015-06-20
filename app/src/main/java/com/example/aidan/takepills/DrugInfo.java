package com.example.aidan.takepills;

/**
 * Created by Aidan on 6/20/15.
 */
public class DrugInfo {

    String name;
    int amount;
    int time;
    int dateEnd;
    boolean morning;
    boolean noon;
    boolean night;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int n) {
        this.amount = n;
    }




}
