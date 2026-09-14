package com.threerive.patterns.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AreaVisitorTest {

  @Test
  void circleArea() {
    Shape circle = new Circle(2.0);
    assertEquals(Math.PI * 4.0, circle.accept(new AreaVisitor()), 0.0001);
  }

  @Test
  void rectangleArea() {
    Shape rectangle = new Rectangle(3.0, 4.0);
    assertEquals(12.0, rectangle.accept(new AreaVisitor()));
  }
}
