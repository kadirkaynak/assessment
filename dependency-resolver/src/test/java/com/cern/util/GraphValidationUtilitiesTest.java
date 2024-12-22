package com.cern.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.cern.util.GraphValidationUtilities.*;
import static org.junit.jupiter.api.Assertions.*;

public class GraphValidationUtilitiesTest {

    @Test
    public void GivenMissingNodes_WhenValidateDirectedGraph_ThenReturnBoolean() {
        // Given: Graph with a missing node
        Map<String, List<String>> adjacencyList = Map.of("A", List.of("B"), "B", List.of("C"), "C", List.of("D"));

        // When
        boolean result = validateDirectedGraph(adjacencyList);

        // Then
        assertTrue(result, "The graph should be invalid due to missing nodes.");
    }

    @Test
    public void GivenValidGraph_WhenValidateDirectedGraph_ThenReturnBoolean() {
        // Given: A valid directed acyclic graph
        Map<String, List<String>> adjacencyList = Map.of("A", List.of("B", "C"), "B", List.of("D"), "C", List.of("D"), "D", List.of());

        // When
        boolean result = validateDirectedGraph(adjacencyList);

        // Then
        assertFalse(result, "The graph should be valid with no issues.");
    }

    @Test
    public void GivenDuplicateEdges_WhenValidateDirectedGraph_ThenReturnBoolean() {
        // Given: Graph with duplicate edges
        Map<String, List<String>> adjacencyList = Map.of("A", List.of("B", "B"), "B", List.of("C"), "C", List.of("D"), "D", List.of());

        // When
        boolean result = validateDirectedGraph(adjacencyList);

        // Then
        assertTrue(result, "The graph should be invalid due to duplicate edges.");
    }

    @Test
    public void GivenCycle_WhenValidateDirectedGraph_ThenReturnBoolean() {
        // Given: Graph with a cycle
        Map<String, List<String>> adjacencyList = Map.of("A", List.of("B"), "B", List.of("C"), "C", List.of("A"));

        // When
        boolean result = validateDirectedGraph(adjacencyList);

        // Then
        assertTrue(result, "The graph should be invalid due to a cycle.");
    }

    @Test
    public void GivenCyclicMap_WhenIsCyclic_ThenReturnBoolean() {
        // Given: Graph with a cycle
        Map<String, List<String>> adjacencyList = Map.of("A", List.of("B"), "B", List.of("C"), "C", List.of("A"));

        // When
        boolean result = isCyclic(adjacencyList);

        // Then
        assertTrue(result, "The graph should have a cycle.");
    }

    @Test
    public void GivenMissingNode_WhenHasMissingNodes_ThenReturnBoolean() {
        // Given: Graph with a missing node
        Map<String, List<String>> adjacencyList = Map.of("A", List.of("B"), "B", List.of("C"), "C", List.of("D"));

        // When
        boolean result = hasMissingNodes(adjacencyList);

        // Then
        assertTrue(result, "The graph should have missing nodes.");
    }

    @Test
    public void GivenMap_WhenHasDuplicateEdges_ThenReturnBoolean() {
        // Given: Graph with duplicate edges
        Map<String, List<String>> adjacencyList = Map.of("A", List.of("B", "B"), "B", List.of("C"), "C", List.of("D"), "D", List.of());

        // When
        boolean result = hasDuplicateEdges(adjacencyList);

        // Then
        assertTrue(result, "The graph should have duplicate edges.");
    }
}

