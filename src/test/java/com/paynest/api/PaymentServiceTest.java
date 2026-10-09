package com.paynest.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private final PaymentService service = new PaymentService();

    @Test
    void feeIsTwoPercent() {
        assertEquals(20.0, service.calculateFee(1000));
    }

    @Test
    void feeHasMinimumOfFive() {
        assertEquals(5.0, service.calculateFee(100));
    }

    @Test
    void zeroAmountIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateFee(0));
    }
}
