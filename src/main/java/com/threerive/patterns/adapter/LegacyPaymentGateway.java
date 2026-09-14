package com.threerive.patterns.adapter;

/** Legacy third-party API with a different method signature. */
public final class LegacyPaymentGateway {

  public boolean payLegacy(int accountNumber, double amountDollars) {
    return accountNumber > 0 && amountDollars > 0;
  }
}
