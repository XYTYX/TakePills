package com.example.aidan.takepills;

import java.util.Vector;

/**
 * Created by Aidan on 6/20/15.
 */
public class DrugDatabase {

    private Vector<DrugInfo> ogVec;

    public DrugDatabase() {
        Vector<DrugInfo> ogVec = new Vector<>();
    }

    public DrugInfo add(DrugInfo add) {
        ogVec.add(add);
        return add;
    }

    public DrugInfo delete(DrugInfo delete) {
        ogVec.remove(delete);
        return delete;
    }

    //The next few methods are for returning a Vector containing only
    //medication that is to be taken during a certain time of day

    public Vector<DrugInfo> isMorning() {
        Vector<DrugInfo> filtered = new Vector<>();
        for (int i = 0; i < ogVec.size() - 1; i++) {
            if (ogVec.get(i).morning) {
                filtered.add(ogVec.get(i));
            }
        }
        return filtered;
    }

    public Vector<DrugInfo> isNoon() {
        Vector<DrugInfo> filtered = new Vector<>();
        for (int i = 0; i < ogVec.size() - 1; i++) {
            if (ogVec.get(i).noon) {
                filtered.add(ogVec.get(i));
            }
        }
        return filtered;
    }

    public Vector<DrugInfo> isNight() {
        Vector<DrugInfo> filtered = new Vector<>();
        for (int i = 0; i < ogVec.size() - 1; i++) {
            if (ogVec.get(i).night) {
                filtered.add(ogVec.get(i));
            }
        }
        return filtered;
    }

    //The message that will eventually be printed out on the main screen
    public String toString(Vector<DrugInfo> write) {
        String end = "Don't forget to take " + write.get(0).toString();
        for (int i = 1; i < write.size() - 1; i++) {
            end = end + ", " + write.get(i).toString();
        }
        return end;
    }
}
