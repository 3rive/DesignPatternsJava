package com.threerive.patterns.state;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VendingMachineTest {

  @Test
  void dispenseRequiresCoin() {
    VendingMachine machine = new VendingMachine();
    assertEquals("insert-coin-first", machine.dispense());
  }

  @Test
  void coinThenDispense() {
    VendingMachine machine = new VendingMachine();
    assertEquals("coin-accepted", machine.insertCoin());
    assertEquals("item-dispensed", machine.dispense());
    assertEquals("insert-coin-first", machine.dispense());
  }
}
