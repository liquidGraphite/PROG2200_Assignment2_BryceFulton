package com.example.prog2200_assignment2_brycefulton.interfaces;

import com.example.prog2200_assignment2_brycefulton.models.Delivery;

public interface IDeliveryService {
    void scheduleDelivery(Delivery delivery);
    Delivery getDeliveryDetails(int deliveryId);
}
