# Spreadsheet Engine
## Features
### Core Functionalities

1. **Spreadsheet Operations:**

* Create a spreadsheet with a fixed number of rows and columns.
* Store, retrieve, and identify values in specific cells.
* Support for value types:
* String: General text.
* Integer: Numeric values.
* Formula: Values starting with =.

2. **Validation:**

* Prevents out-of-bound access or modifications.

3. **Value Management:**

* Trims whitespace for numeric values.
* Preserves whitespace for string values.

4. **Export Functionality:**

* Export spreadsheet data in different formats:
* Dash Format (DashSpreadsheetExporter): Empty cells represented with -.
* Star Format (StarSpreadsheetExporter): Empty cells represented with *.

## Usage
```java
SpreadsheetImpl sheet = Office.newSpreadsheet(10, 5);
```

```java
sheet.put(1, 2, "Hello"); // Store "Hello" in cell (1, 2)
String value = sheet.get(1, 2); // Retrieve value from cell (1, 2)
```

```java
sheet.put(0, 0, "42");
ValueType type = sheet.getValueType(0, 0); // Returns ValueType.INTEGER
```

```java
DashSpreadsheetExporter dashExporter = new DashSpreadsheetExporter(sheet);
String exportedData = dashExporter.export();
```

