package com.threerive.patterns.abstractfactory;

public final class DarkThemeFactory implements ThemeFactory {

  public record DarkButton(String label) implements ThemeWidgets.Button {
    @Override
    public String render() {
      return "[dark-btn:" + label + "]";
    }
  }

  public record DarkLabel(String text) implements ThemeWidgets.Label {
    @Override
    public String render() {
      return "[dark-label:" + text + "]";
    }
  }

  @Override
  public ThemeWidgets.Button createButton(String label) {
    return new DarkButton(label);
  }

  @Override
  public ThemeWidgets.Label createLabel(String text) {
    return new DarkLabel(text);
  }
}
