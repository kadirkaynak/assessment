package com.cern;

import com.cern.impl.SpreadsheetImpl;

public class Office {
    public static SpreadsheetImpl newSpreadsheet(int rows, int columns) {
        return new SpreadsheetImpl(rows, columns);
    }
}