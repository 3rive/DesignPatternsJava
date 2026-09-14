package com.threerive.patterns.injection;

public interface OrderRepository {

  void markPaid(String orderId, String transactionId);
}
