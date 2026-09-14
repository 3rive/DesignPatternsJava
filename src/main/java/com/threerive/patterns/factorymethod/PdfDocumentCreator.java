package com.threerive.patterns.factorymethod;

public final class PdfDocumentCreator extends DocumentCreator {
  @Override
  protected Document createDocument(String body) {
    return new PdfDocument(body);
  }
}
