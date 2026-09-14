package com.threerive.patterns.injection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryOrderRepository implements OrderRepository {

  private final Map<String, String> paidOrders = new ConcurrentHashMap<>();

  @Override
  public void markPaid(String orderId, String transactionId) {
    paidOrders.put(orderId, transactionId);
  }

  public String transactionFor(String orderId) {
    return paidOrders.get(orderId);
  }
}
