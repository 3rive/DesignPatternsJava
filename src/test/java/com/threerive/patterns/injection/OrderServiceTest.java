package com.threerive.patterns.injection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

  private static final Instant FIXED_TIME = Instant.parse("2026-09-14T12:00:00Z");

  @Test
  void checkoutMarksOrderPaidWhenGatewaySucceeds() {
    InMemoryOrderRepository repository = new InMemoryOrderRepository();
    OrderService service =
        new OrderService(
            (orderId, amount) -> new PaymentResult(true, "txn-test-1"),
            repository,
            Clock.fixed(FIXED_TIME, ZoneOffset.UTC));

    CheckoutResult result = service.checkout("order-42", 1999);

    assertTrue(result.paid());
    assertEquals("txn-test-1", result.transactionId());
    assertEquals(FIXED_TIME, result.paidAt());
    assertEquals("txn-test-1", repository.transactionFor("order-42"));
  }

  @Test
  void checkoutDoesNotPersistWhenGatewayFails() {
    InMemoryOrderRepository repository = new InMemoryOrderRepository();
    OrderService service =
        new OrderService(
            (orderId, amount) -> new PaymentResult(false, null),
            repository,
            Clock.systemUTC());

    CheckoutResult result = service.checkout("order-99", 500);

    assertFalse(result.paid());
    assertEquals(null, repository.transactionFor("order-99"));
  }

  @Test
  void applicationContextWiresProductionDependencies() {
    CheckoutResult result = ApplicationContext.orderService().checkout("order-ctx", 1200);

    assertTrue(result.paid());
    assertTrue(result.transactionId().startsWith("txn-"));
  }
}
