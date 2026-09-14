package com.threerive.patterns.interpreter;

import java.util.Map;

public record AddExpression(Expression left, Expression right) implements Expression {
  @Override
  public int interpret(Map<String, Integer> context) {
    return left.interpret(context) + right.interpret(context);
  }
}
