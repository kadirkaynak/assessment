package com.cern.impl;

import com.cern.contract.Spreadsheet;
import com.cern.enums.ValueType;
import com.cern.model.Index;

import java.util.HashMap;
import java.util.Map;

import static utils.Utilities.isInteger;

public class SpreadsheetImpl implements Spreadsheet {
    private final int rows;
    private final int columns;
    private final Map<Index, String> cells;

    public SpreadsheetImpl(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new HashMap<>(rows * columns);
    }

    public String get(int row, int col) {
        controlIndexValidation(row, col);
        return cells.getOrDefault(new Index(row, col), "");
    }

    public void put(int row, int col, String value) {
        controlIndexValidation(row, col);
        if(isInteger(value.trim())) cells.put(new Index(row, col), value.trim());
        else cells.put(new Index(row, col), value);
    }

    private void controlIndexValidation(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= columns) {
            throw new IndexOutOfBoundsException("Index of the Cell is out of bounds.");
        }
    }

    public ValueType getValueType(int row, int col) {
        controlIndexValidation(row, col);

        String value = cells.getOrDefault(new Index(row, col), "");
        if (value.startsWith("=")) {
            return ValueType.FORMULA;
        } else if (isInteger(value.trim())) {
            return ValueType.INTEGER;
        } else {
            return ValueType.STRING;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isEmpty(int row, int col) {
        return get(row, col).isEmpty();
    }
}
