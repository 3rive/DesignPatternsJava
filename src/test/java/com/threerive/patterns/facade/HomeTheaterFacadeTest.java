package com.threerive.patterns.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HomeTheaterFacadeTest {

  @Test
  void watchMovieReturnsMessage() {
    HomeTheaterFacade theater = new HomeTheaterFacade();
    String result = theater.watchMovie("Inception");
    assertEquals("Watching Inception", result);
  }

  @Test
  void messageContainsTitle() {
    HomeTheaterFacade theater = new HomeTheaterFacade();
    assertTrue(theater.watchMovie("Arrival").contains("Arrival"));
  }
}
