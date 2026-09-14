package com.threerive.patterns.command;

public final class Light {

  private boolean on;

  public void turnOn() {
    on = true;
  }

  public void turnOff() {
    on = false;
  }

  public boolean isOn() {
    return on;
  }
}
