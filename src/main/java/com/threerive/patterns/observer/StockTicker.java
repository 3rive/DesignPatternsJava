package com.threerive.patterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Subject in the Observer pattern: maintains stock prices and notifies subscribers
 * when a symbol's price changes.
 */
public final class StockTicker {

  private final List<StockObserver> observers = new ArrayList<>();
  private final Map<String, Double> prices = new HashMap<>();

  public void subscribe(StockObserver observer) {
    observers.add(Objects.requireNonNull(observer, "observer"));
  }

  public void unsubscribe(StockObserver observer) {
    observers.remove(observer);
  }

  public void setPrice(String symbol, double newPrice) {
    Objects.requireNonNull(symbol, "symbol");
    Double previous = prices.get(symbol);
    if (previous != null && Double.compare(previous, newPrice) == 0) {
      return;
    }
    if (previous == null) {
      prices.put(symbol, newPrice);
      return;
    }
    prices.put(symbol, newPrice);
    StockPriceChange change = new StockPriceChange(symbol, previous, newPrice);
    for (StockObserver observer : List.copyOf(observers)) {
      observer.onPriceChange(change);
    }
  }

  public double price(String symbol) {
    return prices.getOrDefault(symbol, Double.NaN);
  }
}
