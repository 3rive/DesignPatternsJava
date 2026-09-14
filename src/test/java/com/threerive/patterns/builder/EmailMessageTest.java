package com.threerive.patterns.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailMessageTest {

  @Test
  void buildsMessageWithFluentBuilder() {
    EmailMessage message =
        EmailMessage.builder()
            .to("user@example.com")
            .subject("Welcome")
            .body("Thanks for signing up.")
            .highPriority(true)
            .build();

    assertEquals("user@example.com", message.to());
    assertEquals("Welcome", message.subject());
    assertTrue(message.highPriority());
    assertEquals(
        "[HIGH] To: user@example.com | Subject: Welcome | Body: Thanks for signing up.",
        message.formatted());
  }

  @Test
  void requiresRecipient() {
    assertThrows(
        IllegalStateException.class,
        () -> EmailMessage.builder().subject("Hi").body("There").build());
  }

  @Test
  void requiresSubject() {
    assertThrows(
        IllegalStateException.class,
        () -> EmailMessage.builder().to("a@b.com").body("There").build());
  }

  @Test
  void allowsEmptyBody() {
    EmailMessage message =
        EmailMessage.builder().to("a@b.com").subject("Ping").body("").build();

    assertEquals("", message.body());
    assertFalse(message.highPriority());
  }
}
