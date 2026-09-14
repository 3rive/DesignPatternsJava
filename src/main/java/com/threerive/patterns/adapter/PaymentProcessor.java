package com.threerive.patterns.adapter;

public interface PaymentProcessor {
  boolean charge(String accountId, int cents);
}
