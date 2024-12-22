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
        return cells[row][col];
    }
}