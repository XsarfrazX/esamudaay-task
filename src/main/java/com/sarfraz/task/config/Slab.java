package com.sarfraz.task.config;

public class Slab {
    long lower;
    long upper;
    long fee;

    public Slab() {

    }

    public long getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public long getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Slab{" +
                "lower=" + lower +
                ", upper=" + upper +
                ", fee=" + fee +
                '}';
    }
}