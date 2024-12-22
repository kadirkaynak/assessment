package com.cern.util;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderUtilitiesTest {

    @Test
    void GivenValidFile_WhenReadFile_ThenReturnMap() throws IOException {
        // Given
        String fileName = "sample-1.json";
        Map<String, List<String>> expectedData = Map.of("pkg1", List.of("pkg2", "pkg3"), "pkg2", List.of("pkg3"), "pkg3", new ArrayList<>());

        // When
        Map<String, List<String>> result = FileReaderUtilities.readFile(fileName);

        // Then
        assertEquals(expectedData, result);
    }

    @Test
    void GivenNonExistentFile_WhenReadFile_ThenThrowException() {
        // Given
        String fileName = "nonexistent.json";

        // When & Then
        assertThrows(FileNotFoundException.class, () -> FileReaderUtilities.readFile(fileName));
    }

}