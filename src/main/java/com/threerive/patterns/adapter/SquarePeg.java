package com.threerive.patterns.adapter;

/** Square pegs cannot be used with {@link RoundHole} without an adapter. */
public final class SquarePeg {

  private final double width;

  public SquarePeg(double width) {
    if (width <= 0) {
      throw new IllegalArgumentException("width must be positive");
    }
    this.width = width;
  }

  public double getWidth() {
    return width;
  }
}
