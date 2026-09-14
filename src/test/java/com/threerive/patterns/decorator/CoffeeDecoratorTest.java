package com.threerive.patterns.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoffeeDecoratorTest {

  @Test
  void stacksDecorators() {
    Coffee coffee = new WhipDecorator(new MilkDecorator(new SimpleCoffee()));
    assertEquals("Coffee, milk, whip", coffee.description());
    assertEquals(325, coffee.costCents());
  }

  @Test
  void milkAloneAddsCost() {
    Coffee coffee = new MilkDecorator(new SimpleCoffee());
    assertEquals(250, coffee.costCents());
    assertEquals("Coffee, milk", coffee.description());
  }
}
