package com.example.lab4;;

public class Interest {
    private double P; // Principal investment amount
    private double r; // Annual interest rate (decimal)
    private double I; // Total interest earned
    private int n;    // Number of times interest is compounded per year
    private int t;    // Number of years the money is invested or borrowed for

    public Interest(double P, double r, int n, int t) {
        this.P = P;
        this.r = r;
        this.n = n;
        this.t = t;
        this.I = 0;
    }

    public double amount() {
        double amount = P * Math.pow(1 + r / n, n * t);
        I = amount - P; // Calculate total interest earned
        return amount;
    }


    public void display() {
        double finalAmount = amount();
        System.out.println("Principal Investment is " + P + " .");
        System.out.println("Total Interest Earned is " + I + " .");
        System.out.println("Final Amount is " + finalAmount + " .");
    }

    public double getP() {
        return P;
    }

    public void setP(double p) {
        P = p;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getI() {
        return I;
    }

    public void setI(double i) {
        I = i;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
}
