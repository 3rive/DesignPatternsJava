package com.threerive.patterns.factory;

/**
 * Simple Factory: clients request a {@link Notification} by {@link NotificationType}
 * without depending on concrete product classes.
 */
public final class NotificationFactory {

  private NotificationFactory() {}

  public static Notification create(NotificationType type) {
    if (type == null) {
      throw new IllegalArgumentException("type must not be null");
    }
    return switch (type) {
      case EMAIL -> new EmailNotification();
      case SMS -> new SmsNotification();
    };
  }
}
