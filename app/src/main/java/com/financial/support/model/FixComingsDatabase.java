package com.financial.support.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.financial.support.enums.TransactionType;

@Entity
public class FixComingsDatabase {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private boolean currentInUse;

    @Ignore
    public FixComingsDatabase() {
    }

    @Ignore
    public FixComingsDatabase(boolean currentInUse) {
        this.currentInUse = currentInUse;
    }

    public FixComingsDatabase(int id, boolean currentInUse) {
        this.id = id;
        this.currentInUse = currentInUse;
    }


    public boolean isCurrentInUse() {
        return currentInUse;
    }

    public void setCurrentInUse(boolean currentInUse) {
        this.currentInUse = currentInUse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}