package com.example.prog2200_assignment2_brycefulton;

import com.example.prog2200_assignment2_brycefulton.models.*;
import com.example.prog2200_assignment2_brycefulton.services.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        PaymentService paymentService = new PaymentService();
        DeliveryService deliveryService = new DeliveryService();
        ReviewService reviewService = new ReviewService();

        Scanner scanner = new Scanner(System.in);

        // Prepopulate products
        productService.addProduct(new Product(1, "Laptop", 1200.00));
        productService.addProduct(new Product(2, "Smartphone", 800.00));
        productService.addProduct(new Product(3, "Headphones", 150.00));

        System.out.println("Welcome to the Courier Service Management System!");

        // Step 1: Select Product
        System.out.println("Available Products:");
        for (Product product : productService.getAllProducts()) {
            System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
        }
        System.out.print("Enter the product ID you want to buy: ");
        int productId = 0;
        while (true) {
            String productIdInput = scanner.nextLine();
            try {
                productId = Integer.parseInt(productIdInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid product ID: ");
            }
        }
        Product selectedProduct = productService.getProductById(productId);
        if (selectedProduct == null) {
            System.out.println("Invalid product ID. Exiting...");
            return;
        }
        System.out.println("You selected: " + selectedProduct.getName() + " - $" + selectedProduct.getPrice());

        // Step 2: Enter Payment Details
        System.out.println("\nEnter payment details:");
        double amount = 0.0;
        while (true) {
            System.out.print("Enter payment amount (must be at least $" + selectedProduct.getPrice() + "): $");
            String amountInput = scanner.nextLine();
            try {
                amount = Double.parseDouble(amountInput);
                if (amount >= selectedProduct.getPrice()) {
                    break;
                } else {
                    System.out.println("Error: Payment amount must be at least the product price.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
        if (!paymentService.processPayment(amount)) {
            System.out.println("Payment failed. Exiting...");
            return;
        }
        Payment payment = new Payment(1, amount, true);
        System.out.println("Payment successful!");

        // Step 3: Enter Delivery Details
        System.out.println("\nEnter delivery details:");
        String address = "";
        while (true) {
            System.out.print("Enter delivery address (cannot be empty): ");
            address = scanner.nextLine();
            if (!address.trim().isEmpty()) {
                break;
            }
            System.out.println("Error: Delivery address cannot be empty.");
        }
        Delivery delivery = new Delivery(1, address, "Scheduled");
        deliveryService.scheduleDelivery(delivery);
        System.out.println("Delivery scheduled to: " + address);

        // Step 4: Enter Review
        System.out.println("\nWould you like to leave a review? (yes/no)");
        String leaveReview = scanner.nextLine();
        if (leaveReview.equalsIgnoreCase("yes")) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your review: ");
            String comments = scanner.nextLine();
            Review review = new Review(1, name, comments);
            reviewService.addReview(review);
        }

        // Step 5: Display Summary
        System.out.println("\nOrder Summary:");
        System.out.println("Product: " + selectedProduct.getName() + " - $" + selectedProduct.getPrice());
        System.out.println("Payment: $" + payment.getAmount() + " - Status: " + (payment.isStatus() ? "Successful" : "Failed"));
        System.out.println("Delivery Address: " + delivery.getAddress());
        System.out.println("Delivery Status: " + delivery.getStatus());
        System.out.println("Customer Reviews:");
        reviewService.displayReviews();
    }
}
