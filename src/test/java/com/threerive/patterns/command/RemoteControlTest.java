package com.threerive.patterns.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RemoteControlTest {

  @Test
  void executeTurnsLightOn() {
    Light light = new Light();
    RemoteControl remote = new RemoteControl();
    remote.setCommand(new LightOnCommand(light));
    remote.pressButton();
    assertTrue(light.isOn());
  }

  @Test
  void undoTurnsLightOff() {
    Light light = new Light();
    RemoteControl remote = new RemoteControl();
    remote.setCommand(new LightOnCommand(light));
    remote.pressButton();
    remote.pressUndo();
    assertFalse(light.isOn());
  }
}
