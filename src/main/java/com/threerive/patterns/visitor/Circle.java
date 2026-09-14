package com.threerive.patterns.visitor;

public record Circle(double radius) implements Shape {
  @Override
  public <T> T accept(ShapeVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
