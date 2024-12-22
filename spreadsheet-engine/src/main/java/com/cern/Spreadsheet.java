package com.cern;

public interface Spreadsheet {
    String get(int row, int col);
    void put(int row, int col, String value);
}
