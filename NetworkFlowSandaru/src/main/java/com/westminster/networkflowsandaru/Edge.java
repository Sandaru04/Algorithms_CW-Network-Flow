/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.networkflowsandaru;

/**
 * Name: Sandaru
 * Student ID: W2083049
 */

public class Edge {
    private int from, to;
    private int capacity;
    private int flow;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int from() { return from; }
    public int to() { return to; }
    public int capacity() { return capacity; }
    public int flow() { return flow; }
    public int residualCapacity() { return capacity - flow; }

    public void addFlow(int additionalFlow) {
        flow += additionalFlow;
    }
}

