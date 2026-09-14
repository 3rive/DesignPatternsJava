package com.threerive.patterns.decorator;

public record MilkDecorator(Coffee delegate) implements Coffee {
  @Override
  public String description() {
    return delegate.description() + ", milk";
  }

  @Override
  public int costCents() {
    return delegate.costCents() + 50;
  }
}
