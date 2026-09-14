package com.threerive.patterns.visitor;

public sealed interface Shape permits Circle, Rectangle {
  <T> T accept(ShapeVisitor<T> visitor);
}
