package com.cern.util;

import com.cern.dto.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.cern.util.PrettifierUtilities.prettifyGraph;
import static org.junit.jupiter.api.Assertions.*;

public class PrettifierUtilitiesTest {

    @Test
    void GivenEmptyList_WhenPrettifyGraph_ThenReturnString() {
        // Given
        List<Node> nodeList = new ArrayList<>();

        // When
        String result = prettifyGraph(nodeList);

        // Then
        assertEquals("", result);
    }

    @Test
    void GivenSingleNode_WhenPrettifyGraph_ThenReturnString() {
        // Given
        Node node = new Node("A");
        List<Node> nodeList = List.of(node);

        // When
        String result = prettifyGraph(nodeList);

        // Then
        assertEquals("- A\n", result);
    }

    @Test
    void GivenNestedNodes_WhenPrettifyGraph_ThenReturnString() {
        // Given
        Node nodeC = new Node("C");
        Node nodeB = new Node("B", List.of(nodeC));
        Node nodeA = new Node("A", List.of(nodeB));
        List<Node> nodeList = List.of(nodeA);

        // When
        String result = prettifyGraph(nodeList);

        // Then
        String expected = """
                - A
                  - B
                    - C
                """;
        assertEquals(expected, result);
    }

    @Test
    void GivenMultipleRootNodes_WhenPrettifyGraph_ThenReturnString() {
        // Given
        Node nodeD = new Node("D");
        Node nodeC = new Node("C");
        Node nodeB = new Node("B", List.of(nodeC));
        Node nodeA = new Node("A", List.of(nodeB));
        List<Node> nodeList = List.of(nodeA, nodeD);

        // When
        String result = prettifyGraph(nodeList);

        // Then
        String expected = """
                - A
                  - B
                    - C
                - D
                """;
        assertEquals(expected, result);
    }

}