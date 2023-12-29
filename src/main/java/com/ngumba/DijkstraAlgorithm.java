package com.ngumba;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 4, 0, 0},
                {0, 0, 2, 5, 0},
                {0, 0, 0, 0, 4},
                {0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0}
        };

        int startNode = 0;
        int[] shortestDistances = dijkstra(graph, startNode);

        // Print the shortest distances from the start node
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println(
                    "Shortest distance from node " + startNode + " to node " + i + ": " + shortestDistances[i]);
        }
    }

    public static int[] dijkstra(int[][] graph, int startNode) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;
        priorityQueue.add(new Node(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int u = currentNode.node;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDistance = distances[u] + graph[u][v];
                    if (newDistance < distances[v]) {
                        distances[v] = newDistance;
                        priorityQueue.add(new Node(v, newDistance));
                    }
                }
            }
        }

        return distances;
    }

    static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
