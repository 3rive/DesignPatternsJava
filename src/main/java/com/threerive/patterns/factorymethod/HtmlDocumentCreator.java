package com.threerive.patterns.factorymethod;

public final class HtmlDocumentCreator extends DocumentCreator {
  @Override
  protected Document createDocument(String body) {
    return new HtmlDocument(body);
  }
}
