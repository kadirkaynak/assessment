package com.cern.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    public void GivenEmptyValue_WhenConstructor_ThenReturnObject() {
        //Given

        //When
        Node node = new Node();

        //Then
        assertNotNull(node.getNeighbors());
        assertTrue(node.getNeighbors().isEmpty());
        assertNull(node.getVal());
    }

    @Test
    void GivenValue_WhenConstructor_ThenReturnObject() {
        //Given
        String value = "A";

        //When
        Node node = new Node(value);

        //Then
        assertNotNull(node.getNeighbors());
        assertTrue(node.getNeighbors().isEmpty());
        assertEquals(value, node.getVal());
    }

    @Test
    void GivenValueAndNeighbors_WhenConstructor_ThenReturnObject() {
        //Given
        String value = "A";
        Node neighbor1 = new Node("B");
        Node neighbor2 = new Node("C");
        List<Node> neighbors = Arrays.asList(neighbor1, neighbor2);

        //When
        Node node = new Node(value, neighbors);

        //Then
        assertEquals(value, node.getVal());
        assertEquals(neighbors, node.getNeighbors());
    }

    @Test
    void GivenNeighbors_WhenGetNeighbors_ThenReturnNeighbors() {
        //Given
        Node node = new Node("A");
        Node neighbor1 = new Node("B");
        Node neighbor2 = new Node("C");
        List<Node> neighbors = Arrays.asList(neighbor1, neighbor2);

        //When
        node.getNeighbors().addAll(neighbors);

        //Then
        assertEquals(2, node.getNeighbors().size());
        assertTrue(node.getNeighbors().contains(neighbor1));
        assertTrue(node.getNeighbors().contains(neighbor2));
    }

    @Test
    void GivenValue_WhenGetVal_ThenReturnValue() {
        //Given
        String value = "A";

        //When
        Node node = new Node(value);

        //Then
        assertEquals(value, node.getVal());
    }
}
