package com.cern;

import com.cern.dto.Node;

import java.io.IOException;
import java.util.*;

import static com.cern.util.FileReaderUtilities.readFile;
import static com.cern.util.GraphResolverUtilities.resolveFullyGraph;
import static com.cern.util.GraphValidationUtilities.validateDirectedGraph;
import static com.cern.util.PrettifierUtilities.prettifyGraph;

public class DependencyResolver {

    public static List<Node> resolveGraph(String fileName) throws IOException {
        Map<String, List<String>> dependencies = readFile(fileName);
        if (validateDirectedGraph(dependencies)) throw new IllegalArgumentException("Validation Error !");
        return resolveFullyGraph(dependencies);
    }

    public static String getPrettyGraph(String fileName) throws IOException {
        List<Node> nodes = resolveGraph(fileName);
        return prettifyGraph(nodes);
    }
}
