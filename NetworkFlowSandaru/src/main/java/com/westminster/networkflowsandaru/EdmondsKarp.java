/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.networkflowsandaru;

/**
 * Name: Sandaru
 * Student ID: W2083049
 */

import java.util.*;

public class EdmondsKarp {
    private FlowNetwork network;
    private int[] parent;

    public EdmondsKarp(FlowNetwork network) {
        this.network = network;
        parent = new int[network.size()];
    }

    private boolean bfs(int source, int sink, Map<String, Edge> edgeMap) {
        boolean[] visited = new boolean[network.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Edge e : network.getAdj(u)) {
                if (!visited[e.to()] && e.residualCapacity() > 0) {
                    parent[e.to()] = u;
                    visited[e.to()] = true;
                    queue.add(e.to());
                }
            }
        }
        return visited[sink];
    }

    public int maxFlow(int source, int sink) {
        int maxFlow = 0;
        Map<String, Edge> edgeMap = new HashMap<>();

        for (int u = 0; u < network.size(); u++) {
            for (Edge e : network.getAdj(u)) {
                edgeMap.put(u + "-" + e.to(), e);
            }
        }

        while (bfs(source, sink, edgeMap)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                Edge e = edgeMap.get(u + "-" + v);
                pathFlow = Math.min(pathFlow, e.residualCapacity());
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                Edge e = edgeMap.get(u + "-" + v);
                e.addFlow(pathFlow);
            }

            maxFlow += pathFlow;
            System.out.println("Augmented path adds flow: " + pathFlow + ", Current max flow: " + maxFlow);
        }

        return maxFlow;
    }
}
