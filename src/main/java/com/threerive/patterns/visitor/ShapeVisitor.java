package com.threerive.patterns.visitor;

public interface ShapeVisitor<T> {
  T visit(Circle circle);

  T visit(Rectangle rectangle);
}
