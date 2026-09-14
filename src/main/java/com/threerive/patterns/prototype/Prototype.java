package com.threerive.patterns.prototype;

/** Prototype: cloneable object copies itself. */
public interface Prototype<T extends Prototype<T>> {
  T copy();
}
