package p21937;

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
            System.out.println(s.solution(getInput(br), getTarget(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<Integer>> getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int numOfNodes = Integer.parseInt(tokens[0]);
        int numOfEdges = Integer.parseInt(tokens[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numOfNodes + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < numOfEdges; i++) {
            tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            graph.get(to).add(from);
        }
        return graph;
    }

    private static int getTarget(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

}

class Solution {

    public int solution(List<List<Integer>> graph, int target) {
        Calculator c = new Calculator(graph);
        return c.getResult(target);
    }
}

class Calculator {

    List<List<Integer>> graph;
    boolean[] isDone;
    int result;

    public Calculator(List<List<Integer>> graph) {
        this.graph = graph;
        this.isDone = new boolean[graph.size()];
        this.result = 0;
    }

    public int getResult(int target) {
        explore(target);
        return result;
    }

    private void explore(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        isDone[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer nextJob : graph.get(cur)) {
                if(isDone[nextJob]) continue;
                result++;
                isDone[nextJob] = true;
                q.offer(nextJob);
            }
        }
    }
}