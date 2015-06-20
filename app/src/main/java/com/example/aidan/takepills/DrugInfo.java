package com.example.aidan.takepills;

/**
 * Created by Aidan on 6/20/15.
 */
public class DrugInfo {

    String name;
    int amount;
    int time;
    int dateStart;
    int dateEnd;
    boolean morning;
    boolean noon;
    boolean night;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }



}
