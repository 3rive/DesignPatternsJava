package com.threerive.patterns.state;

final class IdleState implements VendingState {
  @Override
  public String insertCoin(VendingMachine machine) {
    machine.addCoin();
    machine.setState(new ReadyState());
    return "coin-accepted";
  }

  @Override
  public String dispense(VendingMachine machine) {
    return "insert-coin-first";
  }
}

final class ReadyState implements VendingState {
  @Override
  public String insertCoin(VendingMachine machine) {
    machine.addCoin();
    return "coin-accepted";
  }

  @Override
  public String dispense(VendingMachine machine) {
    if (machine.consumeCoin()) {
      machine.setState(new IdleState());
      return "item-dispensed";
    }
    return "insert-coin-first";
  }
}
