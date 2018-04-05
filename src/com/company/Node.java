package com.company;

class Node {
    public final String value;
    public int heuristiqueCost;
    public double pathCost;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val, int heuristique) {

        value = val;
        this.heuristiqueCost = heuristique;
    }

    public Node(Node node) {
        int i = 0;
        adjacencies = new Edge[node.adjacencies.length];
        value = node.value;
        pathCost = node.pathCost;
        for (Edge e : node.adjacencies) {
            adjacencies[i++] = e;
        }
        parent = node.parent;
    }

    public String toString() {
        return value + pathCost + "   ";
    }

}
