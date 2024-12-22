package com.cern.util;

import com.cern.dto.Node;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.cern.util.GraphResolverUtilities.dp;
import static com.cern.util.GraphResolverUtilities.resolveFullyGraph;
import static org.junit.jupiter.api.Assertions.*;

public class GraphResolverUtilitiesTest {

    @Test
    public void GivenEmptyGraph_WhenResolveFullyGraph_ThenReturnEmptyList() {
        // Given: Empty adjacency list
        Map<String, List<String>> adjacencyList = new HashMap<>();

        // When
        List<Node> result = resolveFullyGraph(adjacencyList);

        // Then
        assertTrue(result.isEmpty(), "Resolved graph should be empty for an empty adjacency list.");
    }

    @Test
    public void GivenSingleNode_WhenResolveFullyGraph_ThenReturn() {
        // Given: Single node without neighbors
        Map<String, List<String>> adjacencyList = Map.of("A", Collections.emptyList());

        // When
        List<Node> result = resolveFullyGraph(adjacencyList);

        // Then
        assertEquals(1, result.size(), "Resolved graph should contain one node.");
        assertEquals("A", result.get(0).getVal(), "The single node should have value 'A'.");
    }

    @Test
    public void GivenMultipleNodes_WhenResolveFullyGraph_ThenReturn() {
        // Given: Multiple nodes with dependencies
        Map<String, List<String>> adjacencyList = new HashMap<>();
        adjacencyList.put("A", List.of("B", "C"));
        adjacencyList.put("B", List.of("D"));
        adjacencyList.put("C", List.of("D"));
        adjacencyList.put("D", new ArrayList<>());

        // When
        List<Node> result = resolveFullyGraph(adjacencyList);

        // Then
        assertEquals(4, result.size(), "Resolved graph should have one root node.");
        Node root = result.get(0);
        assertEquals("A", root.getVal(), "Root node should be 'A'.");
        assertEquals(2, root.getNeighbors().size(), "Root node 'A' should have two neighbors.");

        Node bNode = root.getNeighbors().get(0);
        Node cNode = root.getNeighbors().get(1);
        assertEquals("B", bNode.getVal(), "First neighbor of 'A' should be 'B'.");
        assertEquals("C", cNode.getVal(), "Second neighbor of 'A' should be 'C'.");

        Node dNodeFromB = bNode.getNeighbors().get(0);
        Node dNodeFromC = cNode.getNeighbors().get(0);
        assertEquals("D", dNodeFromB.getVal(), "'B' should have 'D' as its neighbor.");
        assertEquals("D", dNodeFromC.getVal(), "'C' should have 'D' as its neighbor.");
    }

    @Test
    public void GivenDisconnectedNodes_WhenResolveFullyGraph_ThenReturn() {
        // Given: Graph with disconnected components
        Map<String, List<String>> adjacencyList = new HashMap<>();
        adjacencyList.put("A", List.of("B"));
        adjacencyList.put("C", List.of("D"));

        // When
        List<Node> result = resolveFullyGraph(adjacencyList);

        // Then
        assertEquals(2, result.size(), "Resolved graph should have two disconnected root nodes.");
        assertEquals("A", result.get(0).getVal(), "First root node should be 'A'.");
        assertEquals("C", result.get(1).getVal(), "Second root node should be 'C'.");
    }

    @Test
    public void GivenDependency_WhenResolveFullyGraph_ThenUsesMemoization() {
        // Given: Graph with overlapping subtrees
        Map<String, List<String>> adjacencyList = Map.of("A", List.of("B", "C"), "B", List.of("D"), "C", List.of("D"), "D", Collections.emptyList());

        // Clear memoization cache before the _When
        dp.clear();

        // When
        List<Node> result = resolveFullyGraph(adjacencyList);

        // Then
        assertTrue(dp.containsKey("A"), "Memoization should cache node 'A'.");
        assertTrue(dp.containsKey("B"), "Memoization should cache node 'B'.");
        assertTrue(dp.containsKey("C"), "Memoization should cache node 'C'.");
        assertTrue(dp.containsKey("D"), "Memoization should cache node 'D'.");
    }
}