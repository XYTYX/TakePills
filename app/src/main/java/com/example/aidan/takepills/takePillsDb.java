package com.example.aidan.takepills;

import java.util.Date;

/**
 * Created by Byron on 6/21/15.
 */
public class takePillsDb {

    private int _id;
    private String _medName;
    private String _medDose;
    private String _medStatus;
    private String _medDateEnd;

    public takePillsDb() {

    }

    public takePillsDb(int id, String medName, String medDose, String medStatus, String medDateEnd) {
        this._id = id;
        this._medName = medName;
        this._medDose = medDose;
        this._medStatus = medStatus;
        this._medDateEnd = medDateEnd;
    }

    public takePillsDb(String medName, String medDose, String medStatus, String medDateEnd) {
        this._medName = medName;
        this._medDose = medDose;
        this._medStatus = medStatus;
        this._medDateEnd = medDateEnd;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setMedName(String medName) {
        this._medName = medName;
    }

    public String getMedName() {
        return this._medName;
    }

    public void setDose(String medDose) {
        this._medDose = medDose;
    }

    public String getDose() {
        return this._medDose;
    }

    public void setStatus(String medStatus) {
        this._medStatus = medStatus;
    }

    public String getStatus() {
        return this._medStatus;
    }

    public void setDateEnd(String medDateEnd) {
        this._medDateEnd = medDateEnd;
    }

    public String getDateEnd() {
        return this._medDateEnd;
    }
}