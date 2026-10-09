package com.paynest.api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    private final List<Map<String, Object>> payments = new ArrayList<>();

    // Fee = 2% of amount, minimum 5
    public double calculateFee(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be more than 0");
        }
        double fee = amount * 0.02;
        return Math.max(fee, 5.0);
    }

    public Map<String, Object> pay(String customer, double amount) {
        double fee = calculateFee(amount);
        Map<String, Object> payment = Map.of(
                "id", payments.size() + 1,
                "customer", customer,
                "amount", amount,
                "fee", fee,
                "total", amount + fee
        );
        payments.add(payment);
        return payment;
    }

    public List<Map<String, Object>> all() {
        return payments;
    }
}
