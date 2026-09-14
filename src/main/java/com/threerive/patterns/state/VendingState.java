package com.threerive.patterns.state;

public interface VendingState {
  String insertCoin(VendingMachine machine);

  String dispense(VendingMachine machine);
}
