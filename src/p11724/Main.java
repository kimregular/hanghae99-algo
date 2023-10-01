package p11724;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfNodes = Integer.parseInt(st.nextToken());
            int numOfEdges = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= numOfNodes; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < numOfEdges; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                graph.get(num1).add(num2);
                graph.get(num2).add(num1);
            }

            DFSScanner df = new DFSScanner(graph);
            System.out.println(df.getNumOfConnectedComponents());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class DFSScanner {

    ArrayList<ArrayList<Integer>> graph;
    boolean[] isVisited;


    public DFSScanner(ArrayList<ArrayList<Integer>> graph) {
        this.graph = graph;
        this.isVisited = new boolean[graph.size() + 1];
    }

    public int getNumOfConnectedComponents() {
        int numOfConnectedComponents = 0;

        for (int i = 1; i < graph.size(); i++) {
            if (!isVisited[i]) {
                DFS(i);
                numOfConnectedComponents++;
            }
        }

        return numOfConnectedComponents;
    }

    private void DFS(int l) {
        if (isVisited[l]) return;
        isVisited[l] = true;
        for (int i = 0; i < graph.get(l).size(); i++) {
            int nextNode = graph.get(l).get(i);
            if (!isVisited[nextNode]) {
                DFS(nextNode);
            }
        }
    }
}