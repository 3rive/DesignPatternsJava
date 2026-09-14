package com.threerive.patterns.strategy;

public interface PricingStrategy {
  int totalCents(int subtotalCents);
}
