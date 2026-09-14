package com.threerive.patterns.adapter;

/** Adapter wraps legacy gateway to match {@link PaymentProcessor}. */
public final class LegacyPaymentAdapter implements PaymentProcessor {

  private final LegacyPaymentGateway legacy;

  public LegacyPaymentAdapter(LegacyPaymentGateway legacy) {
    this.legacy = legacy;
  }

  @Override
  public boolean charge(String accountId, int cents) {
    int accountNumber = Integer.parseInt(accountId);
    double dollars = cents / 100.0;
    return legacy.payLegacy(accountNumber, dollars);
  }
}
