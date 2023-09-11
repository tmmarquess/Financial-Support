package com.financial.support.model;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import java.util.ArrayList;
import java.util.Date;

import com.financial.support.enums.Months;
import com.financial.support.enums.TransactionType;

public class FinancialMonth extends FinancialMonthDatabase{
    @ColumnInfo
    private FixComings fixComings;
    @ColumnInfo
    private ArrayList<Transaction> transactions;

    public FinancialMonth(Months month, int year, FixComings fixComings) {
        super(month, year);
        this.fixComings = fixComings;
        this.transactions = new ArrayList<>();
    }

    public FinancialMonth(Months month, int year, FixComings fixComings, ArrayList<Transaction> transactions) {
        super(month, year);
        this.fixComings = fixComings;
        this.transactions = transactions;
    }

    @Ignore
    public FinancialMonth(Months month, int year) {
        super(month, year);

        this.fixComings = null;
        this.transactions = new ArrayList<>();
    }

    public FixComings getFixComings() {
        return fixComings;
    }

    public void setFixComings(FixComings fixComings) {
        this.fixComings = fixComings;
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

    public void setTransactions(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    public double getTotalAvailable() {
        double total = fixComings.getTotal();
        for (Transaction transaction : transactions) {
            if(transaction.getType() == TransactionType.Outcome){
                total += transaction.getValue() * -1;
            }else{
                total += transaction.getValue();
            }
        }

        return total;
    }

    public double getTotalOutcomes() {
        double total = fixComings.getOutcomes();
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.Outcome) {
                total += transaction.getValue() * -1;
            }
        }

        return total;
    }

    public double getTotalIncomes() {
        double total = fixComings.getIncomes();
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.Income) {
                total += transaction.getValue();
            }
        }

        return total;
    }

}
