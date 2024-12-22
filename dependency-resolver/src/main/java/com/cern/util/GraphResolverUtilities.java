package com.cern.util;

import com.cern.dto.Node;

import java.util.*;

public class GraphResolverUtilities {

    static Map<String, Node> dp = new HashMap<>();

    public static List<Node> resolveFullyGraph(Map<String, List<String>> adjacencyList) {
        List<Node> result = new ArrayList<>();

        for (String node : adjacencyList.keySet()) {
            buildNestedList(adjacencyList, node, result);
        }

        return result;
    }

    private static void buildNestedList(Map<String, List<String>> adjacencyList, String packageName, List<Node> currentList) {
        List<Node> nestedList = new ArrayList<>();

        if (dp.containsKey(packageName)) {
            currentList.add(dp.get(packageName));
            return;
        }

        List<String> neighbors = adjacencyList.getOrDefault(packageName, Collections.emptyList());
        for (String neighbor : neighbors) {
            buildNestedList(adjacencyList, neighbor, nestedList);
        }

        Node node = new Node(packageName, nestedList);
        dp.put(packageName, node);
        currentList.add(node);
    }
}
