package com.threerive.patterns.factorymethod;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DocumentCreatorTest {

  @Test
  void pdfCreatorProducesPdf() {
    Document doc = new PdfDocumentCreator().open("report");
    assertEquals("application/pdf", doc.mimeType());
    assertEquals("report", doc.body());
  }

  @Test
  void htmlCreatorProducesHtml() {
    Document doc = new HtmlDocumentCreator().open("<p>hi</p>");
    assertEquals("text/html", doc.mimeType());
    assertEquals("<p>hi</p>", doc.body());
  }
}
