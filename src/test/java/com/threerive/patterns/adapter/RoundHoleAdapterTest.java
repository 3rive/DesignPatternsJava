package com.threerive.patterns.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RoundHoleAdapterTest {

  @Test
  void squarePegFitsWhenAdaptedToRoundPeg() {
    RoundHole hole = new RoundHole(5);
    SquarePeg smallSquare = new SquarePeg(5);
    SquarePeg largeSquare = new SquarePeg(10);

    assertTrue(hole.fits(new SquarePegAdapter(smallSquare)));
    assertFalse(hole.fits(new SquarePegAdapter(largeSquare)));
  }

  @Test
  void nativeRoundPegStillFits() {
    RoundHole hole = new RoundHole(3);
    assertTrue(hole.fits(new RoundPeg(3)));
    assertFalse(hole.fits(new RoundPeg(4)));
  }
}
