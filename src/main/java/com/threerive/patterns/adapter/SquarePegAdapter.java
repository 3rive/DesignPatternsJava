package com.threerive.patterns.adapter;

/**
 * Object adapter: subclasses {@link RoundPeg} and delegates to {@link SquarePeg},
 * converting width to an equivalent circumscribed radius.
 */
public final class SquarePegAdapter extends RoundPeg {

  public SquarePegAdapter(SquarePeg peg) {
    super(peg.getWidth() * Math.sqrt(2) / 2.0);
  }
}
