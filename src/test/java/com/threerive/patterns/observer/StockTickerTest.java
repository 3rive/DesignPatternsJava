package com.threerive.patterns.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class StockTickerTest {

  @Test
  void notifiesSubscribersOnPriceChange() {
    StockTicker ticker = new StockTicker();
    List<StockPriceChange> received = new ArrayList<>();
    ticker.subscribe(received::add);

    ticker.setPrice("ACME", 100.0);
    ticker.setPrice("ACME", 110.0);

    assertEquals(1, received.size());
    assertEquals("ACME", received.get(0).symbol());
    assertEquals(100.0, received.get(0).previousPrice());
    assertEquals(110.0, received.get(0).newPrice());
  }

  @Test
  void unsubscribeStopsNotifications() {
    StockTicker ticker = new StockTicker();
    List<StockPriceChange> received = new ArrayList<>();
    StockObserver observer = received::add;
    ticker.subscribe(observer);
    ticker.unsubscribe(observer);

    ticker.setPrice("ACME", 50.0);
    assertTrue(received.isEmpty());
  }

  @Test
  void percentChangeAlertFiresOnLargeMove() {
    StockTicker ticker = new StockTicker();
    PercentChangeAlert alert = new PercentChangeAlert(5.0);
    ticker.subscribe(alert);

    ticker.setPrice("ACME", 100.0);
    ticker.setPrice("ACME", 103.0);
    ticker.setPrice("ACME", 110.0);

    assertEquals(1, alert.alerts().size());
    assertEquals(110.0, alert.alerts().get(0).newPrice());
  }

  @Test
  void identicalPriceDoesNotNotify() {
    StockTicker ticker = new StockTicker();
    List<StockPriceChange> received = new ArrayList<>();
    ticker.subscribe(received::add);

    ticker.setPrice("ACME", 42.0);
    ticker.setPrice("ACME", 42.0);

    assertTrue(received.isEmpty());
  }
}
