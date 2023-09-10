package com.financial.support.model;


import java.util.ArrayList;
import java.util.Date;

import com.financial.support.enums.TransactionType;


public class FixComings extends FixComingsDatabase{
    private ArrayList<Transaction> comings;

    public FixComings() {
        super();
        this.comings = new ArrayList<Transaction>();
    }

    public FixComings(ArrayList<Transaction> comings, boolean currentInUse) {
        super(currentInUse);
        this.comings = comings;
    }

    public FixComings(boolean currentInUse) {
        super(currentInUse);
        this.comings = new ArrayList<Transaction>();
    }

    public FixComings(int id, ArrayList<Transaction> comings, boolean currentInUse) {
        super(id, currentInUse);
        this.comings = comings;
    }

    public void addFixCome(Transaction newCome) {
        comings.add(newCome);
    }

    public void addFixCome(double value, String description, String category, Date date, TransactionType type) {
        comings.add(new Transaction(value, description, category, date, type));
    }

    public ArrayList<Transaction> getComings() {
        return comings;
    }

    public double getIncomes() {
        double total = 0;
        for (Transaction come : comings) {
            if (come.getType() == TransactionType.Income) {
                total += come.getValue();
            }
        }
        return total;
    }

    public double getOutcomes() {
        double total = 0;
        for (Transaction come : comings) {
            if (come.getType() == TransactionType.Outcome) {
                total += come.getValue();
            }
        }
        return total;
    }

    public double getTotal() {
        double total = 0;
        for (Transaction come : comings) {
            total += come.getValue();
        }
        return total;
    }
}