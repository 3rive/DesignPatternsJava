package com.threerive.patterns.factory;

final class EmailNotification implements Notification {

  @Override
  public String channel() {
    return "email";
  }

  @Override
  public String format(String recipient, String message) {
    return "To: " + recipient + " | Subject: Alert | Body: " + message;
  }
}
