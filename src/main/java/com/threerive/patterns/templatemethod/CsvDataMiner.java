package com.threerive.patterns.templatemethod;

public final class CsvDataMiner extends DataMiner {

  @Override
  protected String openSource(String source) {
    return "csv:" + source;
  }

  @Override
  protected String parse(String raw) {
    return raw.replace("csv:", "");
  }
}
