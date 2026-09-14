package com.threerive.patterns.abstractfactory;

/** Abstract Factory: creates families of related theme widgets. */
public interface ThemeFactory {
  ThemeWidgets.Button createButton(String label);

  ThemeWidgets.Label createLabel(String text);
}
