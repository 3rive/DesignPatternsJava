package com.threerive.patterns.strategy;

public final class TenPercentOffPricing implements PricingStrategy {
  @Override
  public int totalCents(int subtotalCents) {
    return (int) Math.round(subtotalCents * 0.9);
  }
}
