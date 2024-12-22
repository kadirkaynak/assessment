package com.cern.contract;

import com.cern.enums.ValueType;

public interface Spreadsheet {
    String get(int row, int col);
    void put(int row, int col, String value);
    ValueType getValueType(int row, int col);
}
