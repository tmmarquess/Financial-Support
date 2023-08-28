package com.financial.support.model;

public class Saving {
    private String cause;
    private double value;

    public Saving(String cause, double value) {
        this.cause = cause;
        this.value = value;
    }

    public Saving() {
    }

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

}
