package com.threerive.patterns.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LegacyPaymentAdapterTest {

  @Test
  void adaptsSuccessfulCharge() {
    PaymentProcessor processor = new LegacyPaymentAdapter(new LegacyPaymentGateway());
    assertTrue(processor.charge("42", 1999));
  }

  @Test
  void rejectsInvalidAccount() {
    PaymentProcessor processor = new LegacyPaymentAdapter(new LegacyPaymentGateway());
    assertFalse(processor.charge("0", 500));
  }
}
