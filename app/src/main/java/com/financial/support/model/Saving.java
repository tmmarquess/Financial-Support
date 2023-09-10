package com.financial.support.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Saving {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String cause;
    @ColumnInfo
    private double value;

    @Ignore
    public Saving(String cause, double value) {
        this.cause = cause;
        this.value = value;
    }

    public Saving(int id, String cause, double value) {
        this.id = id;
        this.cause = cause;
        this.value = value;
    }

    @Ignore
    public Saving() {
    }

    @Ignore
    public Saving(String cause) {
        this.cause = cause;
        this.value = 0;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addValue(double value){
        this.value += value;
    }

    public boolean removeValue(double value){
        if((this.value - value) < 0){
            return false;
        }
        this.value -= value;
        return true;
    }

}
