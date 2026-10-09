package com.paynest.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PaymentController {

    private final PaymentService service;

    @Value("${app.currency}")
    private String currency;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "currency", currency);
    }

    @GetMapping("/api/payments")
    public List<Map<String, Object>> list() {
        return service.all();
    }

    @PostMapping("/api/payments")
    public Map<String, Object> pay(@RequestParam String customer, @RequestParam double amount) {
        return service.pay(customer, amount);
    }
}
