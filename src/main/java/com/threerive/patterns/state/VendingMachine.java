package com.threerive.patterns.state;

public final class VendingMachine {

  private VendingState state = new IdleState();
  private int coins;

  void setState(VendingState state) {
    this.state = state;
  }

  public String insertCoin() {
    return state.insertCoin(this);
  }

  public String dispense() {
    return state.dispense(this);
  }

  void addCoin() {
    coins++;
  }

  boolean consumeCoin() {
    if (coins > 0) {
      coins--;
      return true;
    }
    return false;
  }
}
