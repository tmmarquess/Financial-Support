package com.financial.support.model;

import java.util.Date;

import com.financial.support.enums.TransactionType;

public class Transaction {

    private double value;
    private String description;
    private String category;
    private Date date;
    private TransactionType type;

    public Transaction(double value, String description, String category, Date date, TransactionType type) {
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

}
