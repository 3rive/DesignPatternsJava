package com.threerive.patterns.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ExpressionTest {

  @Test
  void addsLiterals() {
    Expression expr = new AddExpression(new NumberExpression(2), new NumberExpression(3));
    assertEquals(5, expr.interpret(Map.of()));
  }

  @Test
  void nestedAddition() {
    Expression expr =
        new AddExpression(
            new AddExpression(new NumberExpression(1), new NumberExpression(2)),
            new NumberExpression(10));
    assertEquals(13, expr.interpret(Map.of()));
  }
}
