package com.threerive.patterns.injection;

/** Abstraction injected into {@link OrderService}. */
public interface PaymentGateway {

  PaymentResult charge(String orderId, long amountCents);
}
