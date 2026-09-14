package com.threerive.patterns.mediator;

import java.util.HashMap;
import java.util.Map;

public final class ChatRoom implements ChatMediator {

  private final Map<String, ChatUser> users = new HashMap<>();

  @Override
  public void join(String userName, ChatUser user) {
    users.put(userName, user);
    user.attach(this, userName);
  }

  @Override
  public void send(String from, String to, String message) {
    ChatUser recipient = users.get(to);
    if (recipient != null) {
      recipient.receive(from, message);
    }
  }
}
