package com.cern.util;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphValidationUtilities {

    public static boolean validateDirectedGraph(Map<String, List<String>> adjacencyList) {
        return hasMissingNodes(adjacencyList) || hasDuplicateEdges(adjacencyList) || isCyclic(adjacencyList);
    }

    private static boolean isCyclicUtil(Map<String, List<String>> adj, String node, Set<String> visited, Set<String> recStack) {
        if (!visited.contains(node)) {
            visited.add(node);
            recStack.add(node);
            for (String x : adj.get(node)) {
                if (!visited.contains(x) && isCyclicUtil(adj, x, visited, recStack)) {
                    return true;
                } else if (recStack.contains(x)) {
                    return true;
                }
            }
        }

        recStack.remove(node);
        return false;
    }

    public static boolean isCyclic(Map<String, List<String>> adjacencyList) {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();

        for (String node : adjacencyList.keySet()) {
            if (!visited.contains(node) && isCyclicUtil(adjacencyList, node, visited, recStack)) {
                System.out.println("Cyclic dependency detected.");
                return true;
            }
        }

        return false;
    }

    public static boolean hasMissingNodes(Map<String, List<String>> adjacencyList) {
        for (String node : adjacencyList.keySet()) {
            for (String selectedNode : adjacencyList.get(node)) {
                if (!adjacencyList.containsKey(selectedNode)) {
                    System.out.println("Package " + selectedNode + " is missing.");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasDuplicateEdges(Map<String, List<String>> adjacencyList) {
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            Set<String> uniqueEdges = new HashSet<>(entry.getValue());
            if (uniqueEdges.size() != entry.getValue().size()) {
                System.out.println("Duplicate package found for node: " + entry.getKey());
                return true;
            }
        }
        return false;
    }
}
