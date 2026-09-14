package com.threerive.patterns.memento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EditorTest {

  @Test
  void restorePreviousState() {
    Editor editor = new Editor();
    editor.type("hello");
    EditorMemento snapshot = editor.save();
    editor.type(" world");
    assertEquals("hello world", editor.text());
    editor.restore(snapshot);
    assertEquals("hello", editor.text());
    assertEquals(5, editor.cursor());
  }

  @Test
  void mementoCapturesCursor() {
    Editor editor = new Editor();
    editor.type("abc");
    EditorMemento snapshot = editor.save();
    assertEquals(3, snapshot.cursor());
    assertEquals("abc", snapshot.text());
  }
}
