package com.financial.support.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

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