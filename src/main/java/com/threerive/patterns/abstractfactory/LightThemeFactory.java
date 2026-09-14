package com.threerive.patterns.abstractfactory;

public final class LightThemeFactory implements ThemeFactory {

  public record LightButton(String label) implements ThemeWidgets.Button {
    @Override
    public String render() {
      return "[light-btn:" + label + "]";
    }
  }

  public record LightLabel(String text) implements ThemeWidgets.Label {
    @Override
    public String render() {
      return "[light-label:" + text + "]";
    }
  }

  @Override
  public ThemeWidgets.Button createButton(String label) {
    return new LightButton(label);
  }

  @Override
  public ThemeWidgets.Label createLabel(String text) {
    return new LightLabel(text);
  }
}
