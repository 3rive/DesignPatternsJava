package com.threerive.patterns.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NotificationFactoryTest {

  @Test
  void createEmailNotification() {
    Notification notification = NotificationFactory.create(NotificationType.EMAIL);
    assertEquals("email", notification.channel());
    assertEquals(
        "To: user@example.com | Subject: Alert | Body: Order shipped",
        notification.format("user@example.com", "Order shipped"));
  }

  @Test
  void createSmsNotification() {
    Notification notification = NotificationFactory.create(NotificationType.SMS);
    assertEquals("sms", notification.channel());
    assertEquals(
        "SMS to +15551212: Your code is 4821",
        notification.format("+15551212", "Your code is 4821"));
  }

  @Test
  void rejectsNullType() {
    assertThrows(IllegalArgumentException.class, () -> NotificationFactory.create(null));
  }
}
