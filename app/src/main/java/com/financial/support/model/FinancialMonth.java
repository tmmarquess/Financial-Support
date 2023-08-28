package com.financial.support.model;

import java.util.ArrayList;
import java.util.Date;

import com.financial.support.enums.Months;
import com.financial.support.enums.TransactionType;

public class FinancialMonth {
    private Months month;
    private int year;

    private FixCommings fixCommings;
    private ArrayList<Transaction> transactions;

    public FinancialMonth(Months month, int year, FixCommings fixCommings) {
        this.month = month;
        this.year = year;
        this.fixCommings = fixCommings;
        this.transactions = new ArrayList<Transaction>();
    }

    public FinancialMonth(Months month, int year) {
        this.month = month;
        this.year = year;

        this.fixCommings = null;
        this.transactions = new ArrayList<Transaction>();
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

    public FixCommings getFixCommings() {
        return fixCommings;
    }

    public void setFixCommings(FixCommings fixCommings) {
        this.fixCommings = fixCommings;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void addTransaction(double value, String description, String category, Date date, TransactionType type) {
        transactions.add(new Transaction(value, description, category, date, type));
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getTotalAvailable() {
        double total = fixCommings.getTotal();
        for (Transaction transaction : transactions) {
            total += transaction.getValue();
        }

        return total;
    }

    public double getTotalOutcomes() {
        double total = fixCommings.getOutcomes();
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.Outcome) {
                total += transaction.getValue();
            }
        }

        return total;
    }

    public double getTotalIncomes() {
        double total = fixCommings.getIncomes();
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.Income) {
                total += transaction.getValue();
            }
        }

        return total;
    }

}
