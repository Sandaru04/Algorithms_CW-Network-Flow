/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.networkflowsandaru;

/**
 * Name: Sandaru
 * Student ID: W2083049
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputParser {

    public static FlowNetwork parse(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String firstLine = br.readLine();
        if (firstLine == null) {
            br.close();
            throw new IOException("Input file is empty.");
        }

        int nodes;
        try {
            nodes = Integer.parseInt(firstLine.trim());
            if (nodes <= 0) {
                throw new IOException("Number of nodes must be positive.");
            }
        } catch (NumberFormatException e) {
            br.close();
            throw new IOException("Invalid number of nodes: " + firstLine);
        }

        FlowNetwork network = new FlowNetwork(nodes);

        String line;
        int lineNumber = 2; // Because first line was line 1
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue; // Skip blank lines

            String[] parts = line.split("\\s+");
            if (parts.length != 3) {
                br.close();
                throw new IOException("Invalid format at line " + lineNumber + ": " + line);
            }

            try {
                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);
                int capacity = Integer.parseInt(parts[2]);

                // Additional validation
                if (from < 0 || from >= nodes || to < 0 || to >= nodes) {
                    br.close();
                    throw new IOException("Node indices out of bounds at line " + lineNumber + ": " + line);
                }
                if (capacity < 0) {
                    br.close();
                    throw new IOException("Negative capacity at line " + lineNumber + ": " + line);
                }

                network.addEdge(from, to, capacity);

            } catch (NumberFormatException e) {
                br.close();
                throw new IOException("Invalid number format at line " + lineNumber + ": " + line);
            }

            lineNumber++;
        }

        br.close();
        return network;
    }
}








//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class InputParser {
//
//    public static FlowNetwork parse(String filename) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(filename));
//        int nodes = Integer.parseInt(br.readLine().trim());
//        FlowNetwork network = new FlowNetwork(nodes);
//
//        String line;
//        while ((line = br.readLine()) != null) {
//            String[] parts = line.trim().split("\\s+");
//            if (parts.length == 3) {
//                int from = Integer.parseInt(parts[0]);
//                int to = Integer.parseInt(parts[1]);
//                int capacity = Integer.parseInt(parts[2]);
//                network.addEdge(from, to, capacity);
//            }
//        }
//        br.close();
//        return network;
//    }
//}
