package com.threerive.patterns.observer;

/** Immutable event payload published by {@link StockTicker}. */
public record StockPriceChange(String symbol, double previousPrice, double newPrice) {

  public double delta() {
    return newPrice - previousPrice;
  }
}
