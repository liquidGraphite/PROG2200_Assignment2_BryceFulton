package com.example.prog2200_assignment2_brycefulton.models;

public class Review {
    private int reviewId;
    private String customerName;
    private String comments;

    public Review(int reviewId, String customerName, String comments) {
        this.reviewId = reviewId;
        this.customerName = customerName;
        this.comments = comments;
    }

    // Getters and Setters
    public int getReviewId() { return reviewId; }
    public String getCustomerName() { return customerName; }
    public String getComments() { return comments; }

    public void setReviewId(int reviewId) { this.reviewId = reviewId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setComments(String comments) { this.comments = comments; }
}
