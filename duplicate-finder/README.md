# Duplicate Finder
This repository contains a utility function, `findDuplicates`, written in Java, which identifies and returns all duplicate elements from a given list. The duplicates are returned in the order they first appear in the list, and each duplicate appears only once in the output.

## Function Overview

### `findDuplicates`
Detects and returns a list of duplicate elements from the input list while preserving their first appearance order.

### Features
- Generic implementation: Works with any type of objects.
- Maintains the original order of duplicates.
- Ensures each duplicate appears only once in the result.

### Method Signature
```java
public static <T> List<T> findDuplicates(List<T> list)
