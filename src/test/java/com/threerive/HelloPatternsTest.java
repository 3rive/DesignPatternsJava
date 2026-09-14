package com.threerive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloPatternsTest {

  @Test
  void greetingMatchesProjectName() {
    assertEquals("DesignPatternsJava", HelloPatterns.greeting());
  }
}
