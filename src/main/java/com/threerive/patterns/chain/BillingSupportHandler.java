package com.threerive.patterns.chain;

public final class BillingSupportHandler extends SupportHandler {
  @Override
  protected String tryHandle(SupportTicket ticket) {
    if ("billing".equalsIgnoreCase(ticket.topic())) {
      return "billing-handled:" + ticket.id();
    }
    return null;
  }
}
