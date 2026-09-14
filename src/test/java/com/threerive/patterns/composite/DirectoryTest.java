package com.threerive.patterns.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DirectoryTest {

  @Test
  void directoryAggregatesChildSizes() {
    Directory root = new Directory("root");
    root.add(new File("a.txt", 10));
    root.add(new File("b.txt", 5));
    assertEquals(15, root.size());
    assertEquals("root", root.name());
  }

  @Test
  void nestedCompositeSumsRecursively() {
    Directory root = new Directory("root");
    Directory docs = new Directory("docs");
    docs.add(new File("readme.md", 3));
    root.add(docs);
    root.add(new File("app.jar", 7));
    assertEquals(10, root.size());
  }
}
