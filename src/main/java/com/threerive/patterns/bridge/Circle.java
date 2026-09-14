package com.threerive.patterns.bridge;

/** Bridge decouples shape abstraction from rendering implementation. */
public final class Circle {

  private final double radius;
  private final Renderer renderer;

  public Circle(double radius, Renderer renderer) {
    this.radius = radius;
    this.renderer = renderer;
  }

  public String render() {
    return renderer.drawCircle(radius);
  }
}
