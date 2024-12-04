package com.example.prog2200_assignment2_brycefulton.services;

import com.example.prog2200_assignment2_brycefulton.interfaces.IReviewService;
import com.example.prog2200_assignment2_brycefulton.models.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewService implements IReviewService {
    private final List<Review> reviews = new ArrayList<>();

    @Override
    public void addReview(Review review) {
        reviews.add(review);
        System.out.println("Review added: " + review.getComments());
    }

    @Override
    public void displayReviews() {
        System.out.println("Customer Reviews:");
        for (Review review : reviews) {
            System.out.println(" - " + review.getCustomerName() + ": " + review.getComments());
        }
    }
}
