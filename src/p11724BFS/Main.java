package p11724BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
            if (isVisited[i]) continue;
            isVisited[i] = true;
            numOfConnected++;
            BFS(i);
        }
    }

    private void BFS(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int nextNode : graph.get(now)) {
                if(isVisited[nextNode]) continue;
                isVisited[nextNode] = true;
                q.offer(nextNode);
            }
        }
    }
}