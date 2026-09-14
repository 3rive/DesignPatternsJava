package com.threerive.patterns.proxy;

public final class RealImage implements Image {

  private final String filename;

  public RealImage(String filename) {
    this.filename = filename;
  }

  private String loadFromDisk() {
    return "loaded:" + filename;
  }

  @Override
  public String display() {
    return loadFromDisk();
  }
}
