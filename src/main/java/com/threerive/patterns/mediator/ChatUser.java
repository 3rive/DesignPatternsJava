package com.threerive.patterns.mediator;

public final class ChatUser {

  private ChatMediator mediator;
  private String name;

  void attach(ChatMediator mediator, String name) {
    this.mediator = mediator;
    this.name = name;
  }

  public void send(String to, String message) {
    mediator.send(name, to, message);
  }

  private String lastReceivedFrom;
  private String lastMessage;

  void receive(String from, String message) {
    lastReceivedFrom = from;
    lastMessage = message;
  }

  public String lastReceivedFrom() {
    return lastReceivedFrom;
  }

  public String lastMessage() {
    return lastMessage;
  }
}
