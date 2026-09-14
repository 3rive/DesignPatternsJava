package com.threerive.patterns.visitor;

public final class AreaVisitor implements ShapeVisitor<Double> {

  @Override
  public Double visit(Circle circle) {
    return Math.PI * circle.radius() * circle.radius();
  }

  @Override
  public Double visit(Rectangle rectangle) {
    return rectangle.width() * rectangle.height();
  }
}
