package com.threerive.patterns.proxy;

/** Virtual proxy delays expensive loading until display. */
public final class LazyImageProxy implements Image {

  private final String filename;
  private RealImage realImage;

  public LazyImageProxy(String filename) {
    this.filename = filename;
  }

  @Override
  public String display() {
    if (realImage == null) {
      realImage = new RealImage(filename);
    }
    return realImage.display();
  }
}
