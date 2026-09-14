package com.threerive.patterns.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResumeTest {

  @Test
  void copyIsEqualButIndependent() {
    Resume original = new Resume("Alex", List.of("Java", "SQL"));
    Resume clone = original.copy();
    assertEquals(original.name(), clone.name());
    assertEquals(original.skills(), clone.skills());
    assertNotSame(original, clone);
  }

  @Test
  void externalListMutationDoesNotAffectResume() {
    List<String> skills = new ArrayList<>(List.of("Go"));
    Resume original = new Resume("Sam", skills);
    skills.add("Rust");
    assertEquals(List.of("Go"), original.skills());
    assertEquals(List.of("Go"), original.copy().skills());
  }
}
