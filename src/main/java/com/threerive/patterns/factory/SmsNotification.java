package com.threerive.patterns.factory;

final class SmsNotification implements Notification {

  @Override
  public String channel() {
    return "sms";
  }

  @Override
  public String format(String recipient, String message) {
    return "SMS to " + recipient + ": " + message;
  }
}
