package com.threerive.patterns.strategy;

public final class RegularPricing implements PricingStrategy {
  @Override
  public int totalCents(int subtotalCents) {
    return subtotalCents;
  }
}
