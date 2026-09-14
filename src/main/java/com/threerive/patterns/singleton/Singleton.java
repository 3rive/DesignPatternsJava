package com.threerive.patterns.singleton;

import java.lang.LazyConstant;

/**
 * Singleton implemented with Java 27 {@link LazyConstant} (preview): one instance,
 * lazy initialization, and safe publication under concurrent access without
 * hand-rolled double-checked locking.
 */
public final class Singleton {

  private static final LazyConstant<Singleton> INSTANCE = LazyConstant.of(Singleton::new);

  private final String id;

  private Singleton() {
    id = Integer.toHexString(System.identityHashCode(this));
  }

  public static Singleton getInstance() {
    return INSTANCE.get();
  }

  public String id() {
    return id;
  }
}
