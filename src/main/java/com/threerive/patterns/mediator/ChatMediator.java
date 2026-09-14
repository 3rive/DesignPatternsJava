package com.threerive.patterns.mediator;

public interface ChatMediator {
  void send(String from, String to, String message);

  void join(String userName, ChatUser user);
}
