package com.threerive.patterns.command;

public interface Command {
  void execute();

  void undo();
}
