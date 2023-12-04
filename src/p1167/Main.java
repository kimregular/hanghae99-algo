package p1167;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfNodes = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < numOfNodes + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < numOfNodes; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int node = Integer.parseInt(st.nextToken());

                while (true) {
                    int neighbor = Integer.parseInt(st.nextToken());
                    if (neighbor == -1) {
                        break;
                    }
                    int value = Integer.parseInt(st.nextToken());

                    graph.get(node).add(new Edge(neighbor, value));
                }
            }

            GraphExplore ge = new GraphExplore(graph);
            System.out.println(ge.getWidthOfTree());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class GraphExplore {

    ArrayList<ArrayList<Edge>> graph;
    boolean[] isVisited;
    int widthOfTree = 0;
    int extremeNode = 0;

    public GraphExplore(ArrayList<ArrayList<Edge>> graph) {
        this.graph = graph;
        this.isVisited = new boolean[graph.size() + 1];
    }

    public int getWidthOfTree() {
        explore(1, 0);
        this.isVisited = new boolean[graph.size() + 1];
        explore(extremeNode, 0);
        return this.widthOfTree;
    }

    private void explore(int node, int value) {
        this.isVisited[node] = true;
        if (widthOfTree < value) {
            widthOfTree = value;
            extremeNode = node;
        }

        for (Edge nextNeighbor : this.graph.get(node)) {
            if(isVisited[nextNeighbor.destination]) continue;
            explore(nextNeighbor.destination, value + nextNeighbor.value);
        }
    }
}

class Edge {

    int destination;
    int value;

    public Edge(int destination, int value) {
        this.destination = destination;
        this.value = value;
    }
}