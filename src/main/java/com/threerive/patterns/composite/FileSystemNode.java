package com.threerive.patterns.composite;

public sealed interface FileSystemNode permits File, Directory {
  String name();

  int size();
}
