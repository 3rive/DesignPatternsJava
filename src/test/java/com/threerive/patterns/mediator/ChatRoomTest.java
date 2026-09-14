package com.threerive.patterns.mediator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ChatRoomTest {

  @Test
  void deliversDirectMessage() {
    ChatRoom room = new ChatRoom();
    ChatUser alice = new ChatUser();
    ChatUser bob = new ChatUser();
    room.join("alice", alice);
    room.join("bob", bob);
    alice.send("bob", "hello");
    assertEquals("alice", bob.lastReceivedFrom());
    assertEquals("hello", bob.lastMessage());
  }

  @Test
  void unknownRecipientIsIgnored() {
    ChatRoom room = new ChatRoom();
    ChatUser alice = new ChatUser();
    room.join("alice", alice);
    alice.send("ghost", "ping");
    assertNull(alice.lastMessage());
  }
}
