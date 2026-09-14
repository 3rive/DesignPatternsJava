package com.threerive.patterns.adapter;

/** Round pegs are compatible with {@link RoundHole} out of the box. */
public class RoundPeg {

  private final double radius;

  public RoundPeg(double radius) {
    if (radius <= 0) {
      throw new IllegalArgumentException("radius must be positive");
    }
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }
}
