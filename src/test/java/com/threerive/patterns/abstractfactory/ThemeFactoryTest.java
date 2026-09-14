package com.threerive.patterns.abstractfactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ThemeFactoryTest {

  @Test
  void darkThemeFamilyMatches() {
    ThemeFactory factory = new DarkThemeFactory();
    assertEquals("[dark-btn:Save]", factory.createButton("Save").render());
    assertTrue(factory.createLabel("Title").render().startsWith("[dark-label:"));
  }

  @Test
  void lightThemeFamilyMatches() {
    ThemeFactory factory = new LightThemeFactory();
    assertEquals("[light-label:Hello]", factory.createLabel("Hello").render());
    assertEquals("[light-btn:OK]", factory.createButton("OK").render());
  }
}
