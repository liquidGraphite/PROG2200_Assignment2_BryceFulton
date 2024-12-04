package com.example.prog2200_assignment2_brycefulton.models;

public class Payment {
    private int paymentId;
    private double amount;
    private boolean status;

    public Payment(int paymentId, double amount, boolean status) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public int getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public boolean isStatus() { return status; }

    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setStatus(boolean status) { this.status = status; }
}
