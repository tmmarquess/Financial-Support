package com.financial.support.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.util.ArrayList;
import java.util.Date;

import com.financial.support.enums.Months;
import com.financial.support.enums.TransactionType;

@Entity(primaryKeys = {"month", "year"})
public class FinancialMonthDatabase {
    @NonNull
    private Months month;
    @NonNull
    private int year;

    public FinancialMonthDatabase(Months month, int year) {
        this.month = month;
        this.year = year;

    }

    public Months getMonth() {
        return month;
    }

    public void setMonth(Months month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
