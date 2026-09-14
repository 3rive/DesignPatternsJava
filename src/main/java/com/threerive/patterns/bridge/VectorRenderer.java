package com.threerive.patterns.bridge;

public final class VectorRenderer implements Renderer {
  @Override
  public String drawCircle(double radius) {
    return "vector-circle(r=" + radius + ")";
  }
}
