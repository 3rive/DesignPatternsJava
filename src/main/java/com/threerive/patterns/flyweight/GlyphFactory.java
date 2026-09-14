package com.threerive.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/** Flyweight factory shares intrinsic glyph state. */
public final class GlyphFactory {

  private final Map<String, Glyph> pool = new HashMap<>();

  public Glyph glyph(char character, String font) {
    String key = character + "|" + font;
    return pool.computeIfAbsent(key, k -> new Glyph(character, font));
  }

  int poolSize() {
    return pool.size();
  }
}
