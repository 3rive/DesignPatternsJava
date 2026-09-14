package com.threerive.patterns.chain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupportHandlerChainTest {

  private SupportHandler chain;

  @BeforeEach
  void setUp() {
    SupportHandler billing = new BillingSupportHandler();
    SupportHandler tech = new TechnicalSupportHandler();
    billing.linkWith(tech);
    chain = billing;
  }

  @Test
  void firstHandlerResolvesBilling() {
    String result = chain.handle(new SupportTicket("T1", "billing"));
    assertEquals("billing-handled:T1", result);
  }

  @Test
  void passesToNextHandler() {
    String result = chain.handle(new SupportTicket("T2", "tech"));
    assertEquals("tech-handled:T2", result);
  }
}
