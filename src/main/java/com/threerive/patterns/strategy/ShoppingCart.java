package com.threerive.patterns.strategy;

public final class ShoppingCart {

  private PricingStrategy pricingStrategy = new RegularPricing();

  public void setPricingStrategy(PricingStrategy pricingStrategy) {
    this.pricingStrategy = pricingStrategy;
  }

  public int checkout(int subtotalCents) {
    return pricingStrategy.totalCents(subtotalCents);
  }
}
