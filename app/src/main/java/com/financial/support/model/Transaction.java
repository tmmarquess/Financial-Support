package com.financial.support.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

import com.financial.support.enums.TransactionType;

@Entity
public class Transaction implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private double value;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private String category;
    @ColumnInfo
    private Date date;
    @ColumnInfo
    private TransactionType type;

    @Ignore
    public Transaction(double value, String description, String category, Date date, TransactionType type) {
        this.value = value;
        this.description = description;
        this.category = category;
        this.date = date;
        this.type = type;
    }

    public Transaction(int id, double value, String description, String category, Date date, TransactionType type) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.category = category;
        this.date = date;
        this.type = type;
    }

    public double getValue() {
        if (getType() == TransactionType.Outcome) {
            return this.value * -1;
        } else {
            return this.value;
        }
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", value=" + value +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}
