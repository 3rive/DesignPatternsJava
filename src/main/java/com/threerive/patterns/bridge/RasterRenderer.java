package com.threerive.patterns.bridge;

public final class RasterRenderer implements Renderer {
  @Override
  public String drawCircle(double radius) {
    return "raster-circle(r=" + radius + ")";
  }
}
