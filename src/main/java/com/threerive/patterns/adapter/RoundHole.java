package com.threerive.patterns.adapter;

/** Client that only accepts {@link RoundPeg} instances. */
public final class RoundHole {

  private final double radius;

  public RoundHole(double radius) {
    if (radius <= 0) {
      throw new IllegalArgumentException("radius must be positive");
    }
    this.radius = radius;
  }

  public boolean fits(RoundPeg peg) {
    return radius >= peg.getRadius();
  }
}
