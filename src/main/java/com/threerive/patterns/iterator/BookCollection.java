package com.threerive.patterns.iterator;

import java.util.Iterator;
import java.util.List;

public final class BookCollection implements Iterable<Book> {

  private final List<Book> books;

  public BookCollection(List<Book> books) {
    this.books = List.copyOf(books);
  }

  @Override
  public Iterator<Book> iterator() {
    return books.iterator();
  }
}
