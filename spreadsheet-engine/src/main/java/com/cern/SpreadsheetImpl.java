package com.cern;

import java.util.Arrays;

public class SpreadsheetImpl implements Spreadsheet{
    private final int rows;
    private final int columns;
    private final String[][] cells;

    public SpreadsheetImpl(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new String[rows][columns];
        for (String[] row : cells) {
            Arrays.fill(row, "");
        }
    }

    public String get(int row, int col) {
        controlIndexValidation(row, col);
        return cells[row][col];
    }

    public void put(int row, int col, String value) {
        controlIndexValidation(row, col);
        cells[row][col] = value;
    }

    private void controlIndexValidation(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= columns) {
            throw new IndexOutOfBoundsException("Index of the Cell is out of bounds.");
        }
    }
}
