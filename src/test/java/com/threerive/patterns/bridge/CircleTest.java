package com.threerive.patterns.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CircleTest {

  @Test
  void usesVectorRenderer() {
    Circle circle = new Circle(3.0, new VectorRenderer());
    assertEquals("vector-circle(r=3.0)", circle.render());
  }

  @Test
  void usesRasterRenderer() {
    Circle circle = new Circle(1.5, new RasterRenderer());
    assertEquals("raster-circle(r=1.5)", circle.render());
  }
}
