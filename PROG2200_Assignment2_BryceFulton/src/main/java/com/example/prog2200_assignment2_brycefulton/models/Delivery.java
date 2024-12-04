package com.example.prog2200_assignment2_brycefulton.models;

public class Delivery {
    private int deliveryId;
    private String address;
    private String status;

    public Delivery(int deliveryId, String address, String status) {
        this.deliveryId = deliveryId;
        this.address = address;
        this.status = status;
    }

    // Getters and Setters
    public int getDeliveryId() { return deliveryId; }
    public String getAddress() { return address; }
    public String getStatus() { return status; }

    public void setDeliveryId(int deliveryId) { this.deliveryId = deliveryId; }
    public void setAddress(String address) { this.address = address; }
    public void setStatus(String status) { this.status = status; }
}
