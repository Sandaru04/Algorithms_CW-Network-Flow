/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.westminster.networkflowsandaru;

/**
 * Name: Sandaru
 * Student ID: W2083049
 */


//import java.io.IOException;
//
//public class Main {
//    public static void main(String[] args) {
//        // Automatically generate all file names
//        String[] files = new String[39];
//        int index = 0;
//
//        // bridge files bridge_1.txt to bridge_19.txt
//        for (int i = 1; i <= 19; i++) {
//            files[index++] = "bridge_" + i + ".txt";
//        }
//
//        // ladder files ladder_1.txt to ladder_20.txt
//        for (int i = 1; i <= 20; i++) {
//            files[index++] = "ladder_" + i + ".txt";
//        }
//
//        // Loop through all files
//        for (String filename : files) {
//            System.out.println("========== Testing file: " + filename + " ==========");
//
//            try {
//                FlowNetwork network = InputParser.parse(filename);
//                EdmondsKarp ek = new EdmondsKarp(network);
//
//                int source = 0;
//                int sink = network.size() - 1;
//
//                long startTime = System.currentTimeMillis(); // Start timer
//                System.out.println("Calculating maximum flow (Edmonds-Karp) from source " + source + " to sink " + sink + "...");
//                int maxFlow = ek.maxFlow(source, sink);
//                long endTime = System.currentTimeMillis(); // End timer
//
//                System.out.println("Maximum flow for " + filename + ": " + maxFlow);
//                System.out.println("Time taken: " + (endTime - startTime) + " ms");
//
//                // ✅ ADDED: Print all edge flows
//                System.out.println("\nEdge Flows:");
//                for (int u = 0; u < network.size(); u++) {
//                    for (Edge e : network.getAdj(u)) {
//                        System.out.println("Edge " + e.from() + " -> " + e.to() +
//                                ": Flow " + e.flow() + ", Capacity = " + e.capacity());
//                    }
//                }
//
//                System.out.println(); // blank line between files
//
//            } catch (IOException e) {
//                System.out.println("Error reading input file: " + filename + ". " + e.getMessage());
//            }
//        }
//    }
//}






//import java.io.IOException;
//
//public class Main {
//    public static void main(String[] args) {
//        // Automatically generate all file names
//        String[] files = new String[39];
//        int index = 0;
//
//        // bridge files bridge_1.txt to bridge_19.txt
//        for (int i = 1; i <= 19; i++) {
//            files[index++] = "bridge_" + i + ".txt";
//        }
//
//        //  ladder files ladder_1.txt to ladder_20.txt
//        for (int i = 1; i <= 20; i++) {
//            files[index++] = "ladder_" + i + ".txt";
//        }
//
//        // Loop through all files
//        for (String filename : files) {
//            System.out.println("========== Testing file: " + filename + " ==========");
//
//            try {
//                FlowNetwork network = InputParser.parse(filename);
//                EdmondsKarp ek = new EdmondsKarp(network);
//
//                int source = 0;
//                int sink = network.size() - 1;
//
//                long startTime = System.currentTimeMillis(); // Start timer
//                System.out.println("Calculating maximum flow (Edmonds-Karp) from source " + source + " to sink " + sink + "...");
//                int maxFlow = ek.maxFlow(source, sink);
//                long endTime = System.currentTimeMillis(); // End timer
//
//                System.out.println("Maximum flow for " + filename + ": " + maxFlow);
//                System.out.println("Time taken: " + (endTime - startTime) + " ms");
//                System.out.println(); // blank line between files
//
//            } catch (IOException e) {
//                System.out.println("Error reading input file: " + filename + ". " + e.getMessage());
//            }
//            
//        }
//    }
//}






import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // List of files you want to test
        String[] testFiles = {"bridge_1.txt", "ladder_1.txt"};

        for (String filename : testFiles) {
            System.out.println("========== Testing file: " + filename + " ==========");

            try {
                FlowNetwork network = InputParser.parse(filename);
                EdmondsKarp ek = new EdmondsKarp(network);

                int source = 0;
                int sink = network.size() - 1;

                System.out.println("Calculating maximum flow (Edmonds-Karp) from source " + source + " to sink " + sink + "...");
                int maxFlow = ek.maxFlow(source, sink);
                System.out.println("Maximum flow for " + filename + ": " + maxFlow);
                System.out.println(); // extra line for neat output

            } catch (IOException e) {
                System.out.println("Error reading input file: " + filename + ". " + e.getMessage());
            }
        }
    }
}

