package com.threerive.patterns.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookCollectionTest {

  @Test
  void iteratesInOrder() {
    BookCollection collection =
        new BookCollection(List.of(new Book("A"), new Book("B"), new Book("C")));
    List<String> titles = new ArrayList<>();
    for (Book book : collection) {
      titles.add(book.title());
    }
    assertEquals(List.of("A", "B", "C"), titles);
  }

  @Test
  void iteratorStartsAtFirstElement() {
    BookCollection collection = new BookCollection(List.of(new Book("Only")));
    assertEquals("Only", collection.iterator().next().title());
  }
}
