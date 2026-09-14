package com.threerive.patterns.injection;

import java.util.UUID;

/** Default production-style gateway for the composition root. */
public final class ConsolePaymentGateway implements PaymentGateway {

  @Override
  public PaymentResult charge(String orderId, long amountCents) {
    String transactionId = "txn-" + UUID.randomUUID();
    return new PaymentResult(true, transactionId);
  }
}
