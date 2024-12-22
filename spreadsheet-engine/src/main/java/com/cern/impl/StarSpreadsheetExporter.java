package com.cern.impl;

import com.cern.contract.Exporter;

public class StarSpreadsheetExporter implements Exporter {
    private final SpreadsheetImpl sheet;

    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    public String export() {
        StringBuilder builder = new StringBuilder();
        builder.append(sheet.getRows()).append(",").append(sheet.getColumns()).append("#");
        for (int i = 0; i < sheet.getRows(); i++) {
            for (int j = 0; j < sheet.getColumns(); j++) {
                if(!sheet.isEmpty(i, j))builder.append(sheet.get(i, j));
                builder.append("*");
            }
        }
        return builder.toString();
    }
}
