package com.threerive.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public final class Resume implements Prototype<Resume> {

  private final String name;
  private final List<String> skills;

  public Resume(String name, List<String> skills) {
    this.name = name;
    this.skills = new ArrayList<>(skills);
  }

  public String name() {
    return name;
  }

  public List<String> skills() {
    return List.copyOf(skills);
  }

  @Override
  public Resume copy() {
    return new Resume(name, skills);
  }
}
