package com.threerive.patterns.factorymethod;

public abstract class DocumentCreator {

  public final Document open(String body) {
    Document document = createDocument(body);
    return document;
  }

  protected abstract Document createDocument(String body);
}
