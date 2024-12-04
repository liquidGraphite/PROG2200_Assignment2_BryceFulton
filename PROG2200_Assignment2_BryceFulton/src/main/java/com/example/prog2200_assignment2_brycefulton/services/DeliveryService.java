package com.example.prog2200_assignment2_brycefulton.services;

import com.example.prog2200_assignment2_brycefulton.interfaces.IDeliveryService;
import com.example.prog2200_assignment2_brycefulton.models.Delivery;

import java.util.HashMap;
import java.util.Map;

public class DeliveryService implements IDeliveryService {
    private final Map<Integer, Delivery> deliveries = new HashMap<>();

    @Override
    public void scheduleDelivery(Delivery delivery) {
        deliveries.put(delivery.getDeliveryId(), delivery);
        System.out.println("Delivery scheduled for: " + delivery.getAddress());
    }

    @Override
    public Delivery getDeliveryDetails(int deliveryId) {
        return deliveries.get(deliveryId);
    }
}
