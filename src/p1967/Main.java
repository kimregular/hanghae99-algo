package p1967;

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

            for (int i = 0; i < numOfNodes-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph.get(parent).add(new Edge(child, weight));
                graph.get(child).add(new Edge(parent, weight));
            }

            GraphExplorer ge = new GraphExplorer(graph);
            System.out.println(ge.getWidthOfTree());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class GraphExplorer {

    ArrayList<ArrayList<Edge>> graph;
    boolean[] isVisited;
    int widthOfTree = 0;

    public GraphExplorer(ArrayList<ArrayList<Edge>> graph) {
        this.graph = graph;
    }

    public int getWidthOfTree() {
        for (int i = 1; i < this.graph.size(); i++) {
            this.isVisited = new boolean[this.graph.size() + 1];
            explore(i, 0);
        }
        return this.widthOfTree;
    }

    private void explore(int node, int weight) {
        this.isVisited[node] = true;
        this.widthOfTree = Math.max(this.widthOfTree, weight);

        for (Edge child : this.graph.get(node)) {
            if(isVisited[child.destination]) continue;
            explore(child.destination, weight + child.weight);
        }
        this.isVisited[node] = false;
    }

}
class Edge {

    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}