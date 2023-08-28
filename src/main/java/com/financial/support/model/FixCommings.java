package com.financial.support.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.financial.support.enums.TransactionType;

public class FixCommings {
    private List<Transaction> commings;
    private boolean currentInUse;

    public FixCommings() {
        this.commings = new ArrayList<Transaction>();
    }

    public FixCommings(List<Transaction> comings, boolean currentInUse) {
        this.commings = comings;
        this.currentInUse = currentInUse;
    }

    public FixCommings(boolean currentInUse) {
        this.commings = new ArrayList<Transaction>();
        this.currentInUse = currentInUse;
    }

    public void addFixCome(Transaction newCome) {
        commings.add(newCome);
    }

    public void addFixCome(double value, String description, String category, Date date, TransactionType type) {
        commings.add(new Transaction(value, description, category, date, type));
    }

    public List<Transaction> getCommings() {
        return this.commings;
    }

    public boolean isCurrentInUse() {
        return currentInUse;
    }

    public void setCurrentInUse(boolean currentInUse) {
        this.currentInUse = currentInUse;
    }

    public double getIncomes() {
        double total = 0;
        for (Transaction come : commings) {
            if (come.getType() == TransactionType.Income) {
                total += come.getValue();
            }
        }
        return total;
    }

    public double getOutcomes() {
        double total = 0;
        for (Transaction come : commings) {
            if (come.getType() == TransactionType.Outcome) {
                total += come.getValue();
            }
        }
        return total;
    }

    public double getTotal() {
        double total = 0;
        for (Transaction come : commings) {
            total += come.getValue();
        }
        return total;
    }
}
