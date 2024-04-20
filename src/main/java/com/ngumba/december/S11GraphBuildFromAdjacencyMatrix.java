package com.ngumba.december;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S11GraphBuildFromAdjacencyMatrix {

    public static Map<Integer, List<Integer>> preprocessAdjacencyMatrix(int[][] adjacencyMatrix) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int numNodes = adjacencyMatrix.length;

        for (int i = 0; i < numNodes; i++) {
            graph.put(i, new ArrayList<>());
            for (int j = 0; j < numNodes; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] adjacencyMatrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };

        Map<Integer, List<Integer>> graph = preprocessAdjacencyMatrix(adjacencyMatrix);

        // Print the graph
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " ---> " + entry.getValue());
        }
    }
}
