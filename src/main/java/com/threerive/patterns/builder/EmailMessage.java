package com.threerive.patterns.builder;

import java.util.Objects;

/**
 * Immutable product built step-by-step with a fluent {@link Builder}. The constructor
 * is private so callers must use {@link #builder()}.
 */
public final class EmailMessage {

  private final String to;
  private final String subject;
  private final String body;
  private final boolean highPriority;

  private EmailMessage(Builder builder) {
    to = builder.to;
    subject = builder.subject;
    body = builder.body;
    highPriority = builder.highPriority;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String to() {
    return to;
  }

  public String subject() {
    return subject;
  }

  public String body() {
    return body;
  }

  public boolean highPriority() {
    return highPriority;
  }

  public String formatted() {
    String priority = highPriority ? "[HIGH] " : "";
    return priority + "To: " + to + " | Subject: " + subject + " | Body: " + body;
  }

  public static final class Builder {

    private String to;
    private String subject = "";
    private String body = "";
    private boolean highPriority;

    public Builder to(String to) {
      this.to = to;
      return this;
    }

    public Builder subject(String subject) {
      this.subject = Objects.requireNonNullElse(subject, "");
      return this;
    }

    public Builder body(String body) {
      this.body = Objects.requireNonNullElse(body, "");
      return this;
    }

    public Builder highPriority(boolean highPriority) {
      this.highPriority = highPriority;
      return this;
    }

    public EmailMessage build() {
      if (to == null || to.isBlank()) {
        throw new IllegalStateException("to is required");
      }
      if (subject.isBlank()) {
        throw new IllegalStateException("subject is required");
      }
      return new EmailMessage(this);
    }
  }
}
