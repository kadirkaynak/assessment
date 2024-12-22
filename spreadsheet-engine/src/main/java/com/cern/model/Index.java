package com.cern.model;

import java.util.Objects;

public class Index {
    private int row;
    private int column;

    public Index(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If the same instance, return true
        if (o == null || getClass() != o.getClass()) return false; // Null check and class type check
        Index index = (Index) o; // Cast the object
        return row == index.row && column == index.column; // Compare row and column
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column); // Combine row and column for hash code
    }
}
