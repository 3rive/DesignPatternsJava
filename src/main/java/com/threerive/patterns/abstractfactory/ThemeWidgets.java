package com.threerive.patterns.abstractfactory;

public final class ThemeWidgets {

  private ThemeWidgets() {}

  public sealed interface Button permits DarkThemeFactory.DarkButton, LightThemeFactory.LightButton {
    String label();

    String render();
  }

  public sealed interface Label permits DarkThemeFactory.DarkLabel, LightThemeFactory.LightLabel {
    String text();

    String render();
  }
}
