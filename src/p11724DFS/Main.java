package p11724DFS;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<Integer>> getInput(BufferedReader br) throws IOException {
        String[] dimension = br.readLine().split(" ");
        int numOfNodes = Integer.parseInt(dimension[0]) + 1;
        int numOfEdges = Integer.parseInt(dimension[1]);

        List<List<Integer>> graph = new ArrayList<>();
        while(numOfNodes --> 0) graph.add(new ArrayList<>());
        while (numOfEdges-- > 0) {
            String[] tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        return graph;
    }
}

class Solution {

    public int solution(List<List<Integer>> graph) {
        Calculator c = new Calculator(graph);
        return c.getResult();
    }
}

class Calculator {

    List<List<Integer>> graph;
    boolean[] isVisited;
    int numOfConnected = 0;

    public Calculator(List<List<Integer>> graph) {
        this.graph = graph;
        this.isVisited = new boolean[graph.size()];
    }

    public int getResult() {
        explore();
        return numOfConnected;
    }

    private void explore() {
        for (int i = 1; i < graph.size(); i++) {
            if(isVisited[i]) continue;
            numOfConnected++;
            DFS(i);
        }
    }

    private void DFS(int i) {
        if(isVisited[i]) return;
        isVisited[i] = true;
        for (int nextNode : graph.get(i)) {
            if(isVisited[nextNode]) continue;
            DFS(nextNode);
        }
    }
}