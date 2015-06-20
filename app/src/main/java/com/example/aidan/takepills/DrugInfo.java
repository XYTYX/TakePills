package com.example.aidan.takepills;

/**
 * Created by Aidan on 6/20/15.
 */
public class DrugInfo {

    String name;
    int amount;
    int dateEnd;
    boolean morning;
    boolean noon;
    boolean night;

    public DrugInfo(String name, int amount, int dateEnd, boolean morning,
                    boolean noon, boolean night) {
        this.name = name;
        this.amount = amount;
        this.dateEnd = dateEnd;
        this.morning = morning;
        this.noon = noon;
        this.night = night;
    }

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

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public boolean isNoon() {
        return noon;
    }

    public void setNoon(boolean noon) {
        this.noon = noon;
    }

    public boolean isNight() {
        return night;
    }

    public void setNight(boolean night) {
        this.night = night;
    }

    public int getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(int dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String toString() {
        return this.amount + " dose(s) of " + this.name;
    }

}
