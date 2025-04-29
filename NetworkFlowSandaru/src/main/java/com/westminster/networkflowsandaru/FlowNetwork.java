/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.networkflowsandaru;

/**
 * Name: Sandaru
 * Student ID: W2083049
 */

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
    private int nodes;
    private List<Edge>[] adjList;

    public FlowNetwork(int nodes) {
        this.nodes = nodes;
        adjList = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int capacity) {
        Edge edge = new Edge(from, to, capacity);
        adjList[from].add(edge);
    }

    public List<Edge> getAdj(int node) {
        return adjList[node];
    }

    public int size() {
        return nodes;
    }
}
