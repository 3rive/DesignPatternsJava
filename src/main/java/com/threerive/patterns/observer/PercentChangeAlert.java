package com.threerive.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer that records symbols whose price moved at least {@code thresholdPercent}
 * relative to the previous price.
 */
public final class PercentChangeAlert implements StockObserver {

  private final double thresholdPercent;
  private final List<StockPriceChange> alerts = new ArrayList<>();

  public PercentChangeAlert(double thresholdPercent) {
    if (thresholdPercent < 0) {
      throw new IllegalArgumentException("thresholdPercent must be non-negative");
    }
    this.thresholdPercent = thresholdPercent;
  }

  @Override
  public void onPriceChange(StockPriceChange change) {
    if (change.previousPrice() == 0) {
      return;
    }
    double percentMove =
        Math.abs(change.delta() / change.previousPrice()) * 100.0;
    if (percentMove >= thresholdPercent) {
      alerts.add(change);
    }
  }

  public List<StockPriceChange> alerts() {
    return List.copyOf(alerts);
  }
}
