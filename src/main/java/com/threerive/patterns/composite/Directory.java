package com.threerive.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public final class Directory implements FileSystemNode {

  private final String name;
  private final List<FileSystemNode> children = new ArrayList<>();

  public Directory(String name) {
    this.name = name;
  }

  public void add(FileSystemNode node) {
    children.add(node);
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public int size() {
    return children.stream().mapToInt(FileSystemNode::size).sum();
  }
}
