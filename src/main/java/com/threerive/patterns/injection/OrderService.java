package com.threerive.patterns.injection;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;

/**
 * Consumer with constructor-injected dependencies. It never instantiates
 * {@link PaymentGateway} or {@link OrderRepository} itself.
 */
public final class OrderService {

  private final PaymentGateway paymentGateway;
  private final OrderRepository orderRepository;
  private final Clock clock;

  public OrderService(
      PaymentGateway paymentGateway, OrderRepository orderRepository, Clock clock) {
    this.paymentGateway = Objects.requireNonNull(paymentGateway, "paymentGateway");
    this.orderRepository = Objects.requireNonNull(orderRepository, "orderRepository");
    this.clock = Objects.requireNonNull(clock, "clock");
  }

  public CheckoutResult checkout(String orderId, long amountCents) {
    Objects.requireNonNull(orderId, "orderId");
    if (amountCents <= 0) {
      throw new IllegalArgumentException("amountCents must be positive");
    }

    PaymentResult payment = paymentGateway.charge(orderId, amountCents);
    if (!payment.success()) {
      return new CheckoutResult(orderId, false, null, null);
    }

    orderRepository.markPaid(orderId, payment.transactionId());
    return new CheckoutResult(
        orderId, true, payment.transactionId(), clock.instant());
  }
}
