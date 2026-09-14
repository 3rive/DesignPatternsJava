package com.threerive.patterns.injection;

import java.lang.LazyConstant;
import java.time.Clock;

/**
 * Composition root: wires concrete implementations and exposes fully constructed
 * services. Java 27 {@link LazyConstant} lazily creates shared infrastructure
 * beans without eager static initialization.
 */
public final class ApplicationContext {

  private static final LazyConstant<PaymentGateway> PAYMENT_GATEWAY =
      LazyConstant.of(ConsolePaymentGateway::new);

  private static final LazyConstant<OrderRepository> ORDER_REPOSITORY =
      LazyConstant.of(InMemoryOrderRepository::new);

  private static final LazyConstant<Clock> CLOCK = LazyConstant.of(Clock::systemUTC);

  private static final LazyConstant<OrderService> ORDER_SERVICE =
      LazyConstant.of(
          () ->
              new OrderService(
                  PAYMENT_GATEWAY.get(), ORDER_REPOSITORY.get(), CLOCK.get()));

  private ApplicationContext() {}

  public static OrderService orderService() {
    return ORDER_SERVICE.get();
  }
}
