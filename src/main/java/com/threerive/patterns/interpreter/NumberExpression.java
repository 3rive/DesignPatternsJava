package com.threerive.patterns.interpreter;

import java.util.Map;

public record NumberExpression(int value) implements Expression {
  @Override
  public int interpret(Map<String, Integer> context) {
    return value;
  }
}
