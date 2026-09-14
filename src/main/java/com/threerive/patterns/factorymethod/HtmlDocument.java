package com.threerive.patterns.factorymethod;

public record HtmlDocument(String body) implements Document {
  @Override
  public String mimeType() {
    return "text/html";
  }
}
