package com.threerive.patterns.templatemethod;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CsvDataMinerTest {

  @Test
  void runsTemplateSteps() {
    DataMiner miner = new CsvDataMiner();
    assertEquals("SALES.CSV", miner.mine("sales.csv"));
  }

  @Test
  void parseStripsPrefixBeforeAnalyze() {
    CsvDataMiner miner = new CsvDataMiner();
    assertEquals("data", miner.parse("csv:data"));
  }
}
