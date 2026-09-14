package com.threerive.patterns.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

class SingletonTest {

  @Test
  void getInstanceReturnsSameObject() {
    Singleton first = Singleton.getInstance();
    Singleton second = Singleton.getInstance();
    assertSame(first, second);
    assertEquals(first.id(), second.id());
  }

  @Test
  void getInstanceIsThreadSafe() throws Exception {
    try (var executor = Executors.newFixedThreadPool(16)) {
      Set<Singleton> instances = ConcurrentHashMap.newKeySet();
      var tasks = executor.invokeAll(
          java.util.Collections.nCopies(64, () -> instances.add(Singleton.getInstance())));
      for (var future : tasks) {
        future.get();
      }
      assertEquals(1, instances.size());
    }
  }
}
