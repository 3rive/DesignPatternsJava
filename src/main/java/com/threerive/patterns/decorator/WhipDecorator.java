package com.threerive.patterns.decorator;

public record WhipDecorator(Coffee delegate) implements Coffee {
  @Override
  public String description() {
    return delegate.description() + ", whip";
  }

  @Override
  public int costCents() {
    return delegate.costCents() + 75;
  }
}
