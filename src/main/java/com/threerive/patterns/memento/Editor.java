package com.threerive.patterns.memento;

/** Originator saves and restores state via memento. */
public final class Editor {

  private String text = "";
  private int cursor;

  public void type(String chunk) {
    text = text + chunk;
    cursor = text.length();
  }

  public EditorMemento save() {
    return new EditorMemento(text, cursor);
  }

  public void restore(EditorMemento memento) {
    this.text = memento.text();
    this.cursor = memento.cursor();
  }

  public String text() {
    return text;
  }

  public int cursor() {
    return cursor;
  }
}
