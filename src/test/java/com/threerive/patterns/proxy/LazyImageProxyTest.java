package com.threerive.patterns.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LazyImageProxyTest {

  @Test
  void displayLoadsOnFirstAccess() {
    Image image = new LazyImageProxy("photo.png");
    assertEquals("loaded:photo.png", image.display());
  }

  @Test
  void secondDisplayIsStable() {
    LazyImageProxy proxy = new LazyImageProxy("map.jpg");
    String first = proxy.display();
    assertEquals(first, proxy.display());
  }
}
