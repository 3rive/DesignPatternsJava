package com.threerive.patterns.decorator;

public final class SimpleCoffee implements Coffee {
  @Override
  public String description() {
    return "Coffee";
  }

  @Override
  public int costCents() {
    return 200;
  }
}
