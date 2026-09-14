package com.threerive.patterns.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class GlyphFactoryTest {

  @Test
  void reusesSameGlyphInstance() {
    GlyphFactory factory = new GlyphFactory();
    Glyph a1 = factory.glyph('a', "Serif");
    Glyph a2 = factory.glyph('a', "Serif");
    assertSame(a1, a2);
    assertEquals(1, factory.poolSize());
  }

  @Test
  void differentKeysCreateDistinctGlyphs() {
    GlyphFactory factory = new GlyphFactory();
    factory.glyph('a', "Serif");
    factory.glyph('b', "Serif");
    assertEquals(2, factory.poolSize());
  }
}
