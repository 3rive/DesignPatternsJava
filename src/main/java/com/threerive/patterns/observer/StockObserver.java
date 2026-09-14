package com.threerive.patterns.observer;

/** Observer contract for {@link StockTicker} price updates. */
public interface StockObserver {

  void onPriceChange(StockPriceChange change);
}
