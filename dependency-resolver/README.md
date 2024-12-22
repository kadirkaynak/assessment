# Dependency Resolver
## Overview
The DependencyResolver Java class provides utilities for processing a dependency graph. It can:

Parse a JSON file containing dependencies.

Resolve the full dependency graph.

Detect cyclic dependencies.

Generate a nested list representation of a graph.

Pretty-print the resolved dependency graph.

### Features
1. Resolve Dependencies from JSON

The `resolveGraph` method reads a JSON file and constructs a map of the full dependency graph.

2. Pretty-Print Graph

The `getPrettyGraph` method provides a human-readable representation of the dependency graph.

### Method Signature

`resolveGraph`
```java
public static List<Node> resolveGraph(String fileName) throws IOException;
```
Reads a JSON file and constructs the full dependency graph.

Input: FileName to a JSON file.

Output: A Map representing the resolved dependency graph.

Throws: IOException if the file cannot be read.


`getPrettyGraph`
```java
public static String getPrettyGraph(String fileName) throws IOException;
```
Generates a formatted string of the resolved dependency graph.

Input: Path to a JSON file.

Output: A pretty-printed string representation of the graph.
