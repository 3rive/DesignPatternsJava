package com.threerive.patterns.templatemethod;

/** Template Method defines skeleton; subclasses fill in steps. */
public abstract class DataMiner {

  public final String mine(String source) {
    String raw = openSource(source);
    String parsed = parse(raw);
    closeSource(source);
    return analyze(parsed);
  }

  protected abstract String openSource(String source);

  protected abstract String parse(String raw);

  protected void closeSource(String source) {}

  protected String analyze(String parsed) {
    return parsed.toUpperCase();
  }
}
