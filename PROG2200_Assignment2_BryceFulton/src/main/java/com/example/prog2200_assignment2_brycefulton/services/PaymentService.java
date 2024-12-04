package com.example.prog2200_assignment2_brycefulton.services;

import com.example.prog2200_assignment2_brycefulton.interfaces.IPaymentService;

public class PaymentService implements IPaymentService {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
        return amount > 0;
    }
}
