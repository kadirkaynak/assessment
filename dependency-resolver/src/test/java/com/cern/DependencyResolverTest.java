package com.cern;

import com.cern.dto.Node;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.cern.DependencyResolver.getPrettyGraph;
import static com.cern.DependencyResolver.resolveGraph;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DependencyResolverTest {

    @Test
    public void GivenValidGraph_WhenResolveGraph_ThenReturnResolvedGraph() throws IOException {
        // Given
        String fileName = "valid.json";

        // When
        List<Node> result = resolveGraph(fileName);

        // Then
        assertEquals(3, result.size(), "There should be one root node.");
        assertEquals("A", result.get(0).getVal(), "Root node should be 'A'.");
    }

    @Test
    public void GivenInvalidGraph_WhenResolveGraph_ThenReturnResolvedGraph() throws IOException {
        // Given
        String fileName = "invalid.json";

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> resolveGraph(fileName), "A validation error should be thrown for an invalid graph.");
        assertEquals("Validation Error !", exception.getMessage());
    }

    @Test
    public void GivenValidGraph_WhenResolveGraph_ThenReturnGetPrettyGraph() throws IOException {
        // Given
        String fileName = "valid.json";
        String expectedPrettyGraph = """
                - A
                  - B
                    - C
                  - C
                - B
                  - C
                - C
                """;

        // When
        String result = getPrettyGraph(fileName);

        // Then
        assertEquals(expectedPrettyGraph.trim(), result.trim(), "The prettified graph should match the expected output.");
    }

    @Test
    public void testResolveGraphThrowsIOException() {
        // Given
        String fileName = "nonExistentFile.json";

        // When & Then
        assertThrows(IOException.class, () -> resolveGraph(fileName), "An IOException should be thrown when the file is not found.");
    }
}