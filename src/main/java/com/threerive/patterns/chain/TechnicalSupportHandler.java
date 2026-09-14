package com.threerive.patterns.chain;

public final class TechnicalSupportHandler extends SupportHandler {
  @Override
  protected String tryHandle(SupportTicket ticket) {
    if ("tech".equalsIgnoreCase(ticket.topic())) {
      return "tech-handled:" + ticket.id();
    }
    return null;
  }
}
