package com.threerive.patterns.composite;

public record File(String name, int size) implements FileSystemNode {}
