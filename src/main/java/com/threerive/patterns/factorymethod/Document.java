package com.threerive.patterns.factorymethod;

/** Factory Method: subclasses decide which {@link Document} to instantiate. */
public sealed interface Document permits PdfDocument, HtmlDocument {
  String mimeType();

  String body();
}
