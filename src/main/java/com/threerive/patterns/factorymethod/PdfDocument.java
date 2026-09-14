package com.threerive.patterns.factorymethod;

public record PdfDocument(String body) implements Document {
  @Override
  public String mimeType() {
    return "application/pdf";
  }
}
