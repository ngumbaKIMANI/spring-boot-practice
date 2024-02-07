package com.ngumba.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphsOperations {

    //given an adjacency matrix representing an undirected graph, create an adjacency list representing the same graph
    public static Map<Integer, List<Integer>> createAdjacencyList(int[][] adjacencyMatrix) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        int vertices = adjacencyMatrix.length;
        for (int i = 0; i < vertices; i++) {
            if (!adjacencyList.containsKey(i)) {
                adjacencyList.put(i, new ArrayList<>());
            }

            for (int j = i + 1; j < vertices; j++) {

                if (!adjacencyList.containsKey(j)) {
                    adjacencyList.put(j, new ArrayList<>());
                }

                if (adjacencyMatrix[i][j] == 1) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);  // Since it's an undirected graph
                }
            }
        }

        return adjacencyList;  //return the adjacency list created from the adjacency matrix
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        Map<Integer, List<Integer>> adjacencyList = createAdjacencyList(adjacencyMatrix);

        // Print the resulting adjacency list
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
