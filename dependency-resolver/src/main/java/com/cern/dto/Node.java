package com.cern.dto;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String val;
    private List<Node> neighbors;

    public Node() {
        neighbors = new ArrayList<>();
    }

    public Node(String node) {
        val = node;
        neighbors = new ArrayList<>();
    }

    public Node(String node, List<Node> neighbors) {
        this.val = node;
        this.neighbors = neighbors;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public String getVal() {
        return val;
    }
}
