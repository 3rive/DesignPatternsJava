package com.threerive.patterns.command;

public final class RemoteControl {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void pressButton() {
    if (command != null) {
      command.execute();
    }
  }

  public void pressUndo() {
    if (command != null) {
      command.undo();
    }
  }
}
