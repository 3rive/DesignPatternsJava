package com.threerive;

/**
 * Entry point for manual smoke runs ({@code java -cp target/classes com.threerive.HelloPatterns}).
 */
public final class HelloPatterns {

  private HelloPatterns() {}

  public static String greeting() {
    return "DesignPatternsJava";
  }

  public static void main(String[] args) {
    System.out.println(greeting());
  }
}
