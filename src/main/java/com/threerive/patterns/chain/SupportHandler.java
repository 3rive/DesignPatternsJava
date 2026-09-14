package com.threerive.patterns.chain;

/** Chain of Responsibility: handlers pass unhandled tickets to a successor. */
public abstract class SupportHandler {

  private SupportHandler next;

  public SupportHandler linkWith(SupportHandler next) {
    this.next = next;
    return next;
  }

  public String handle(SupportTicket ticket) {
    String result = tryHandle(ticket);
    if (result != null) {
      return result;
    }
    if (next != null) {
      return next.handle(ticket);
    }
    return "unhandled:" + ticket.id();
  }

  protected abstract String tryHandle(SupportTicket ticket);
}
