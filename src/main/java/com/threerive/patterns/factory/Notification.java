package com.threerive.patterns.factory;

/** Product created by {@link NotificationFactory}. */
public interface Notification {

  String channel();

  String format(String recipient, String message);
}
