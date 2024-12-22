package com.cern.util;

import com.cern.dto.Node;

import java.util.List;

public class PrettifierUtilities {

    public static String prettifyGraph(List<Node> nodeList) {
        StringBuilder prettifiedFile = new StringBuilder();

        for (Node node : nodeList) {
            prettifyNestedGraph(prettifiedFile, node, 0);
        }

        return prettifiedFile.toString();
    }

    public static void prettifyNestedGraph(StringBuilder prettifiedFile, Node node, int depth) {
        prettifiedFile.append("  ".repeat(depth)).append("- ").append(node.getVal()).append("\n");
        for (Node nodeItem : node.getNeighbors()) {
            prettifyNestedGraph(prettifiedFile, nodeItem, depth + 1);
        }
    }
}
