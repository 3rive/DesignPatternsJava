package com.threerive.patterns.injection;

import java.time.Instant;

public record CheckoutResult(
    String orderId, boolean paid, String transactionId, Instant paidAt) {}
