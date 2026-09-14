package com.threerive.patterns.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {

  @Test
  void regularPricing() {
    ShoppingCart cart = new ShoppingCart();
    assertEquals(1000, cart.checkout(1000));
  }

  @Test
  void discountPricing() {
    ShoppingCart cart = new ShoppingCart();
    cart.setPricingStrategy(new TenPercentOffPricing());
    assertEquals(900, cart.checkout(1000));
  }
}
