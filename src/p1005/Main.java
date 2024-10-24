package p1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            TestCase[] testCases = readInput(br);
            Solution s = new Solution();
            for (TestCase testCase : testCases) {
                System.out.println(s.solution(testCase.costs, testCase.graph, testCase.target));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private TestCase[] readInput(BufferedReader br) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        TestCase[] result = new TestCase[testCase];


        for (int i = 0; i < testCase; i++) {
            List<List<Integer>> graph  = new ArrayList<>();
            String[] tokens = br.readLine().split(" ");
            int numOfNodes = Integer.parseInt(tokens[0]);
            int numOfLinks = Integer.parseInt(tokens[1]);

            for (int j = 0; j < numOfNodes + 1; j++) {
                graph.add(new ArrayList<>());
            }

            int[] costs = new int[graph.size()];
            costs[0] = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < costs.length; j++) {
                costs[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < numOfLinks; j++) {
                tokens = br.readLine().split(" ");
                int from = Integer.parseInt(tokens[0]);
                int to = Integer.parseInt(tokens[1]);
                graph.get(from).add(to);
            }

            int target = Integer.parseInt(br.readLine());

            result[i] = new TestCase(costs, graph, target);
        }
        return result;
    }

    private static class TestCase {
        private final int[] costs;
        private final List<List<Integer>> graph;
        private final int target;

        public TestCase(int[] costs, List<List<Integer>> graph, int target) {
            this.costs = costs;
            this.graph = graph;
            this.target = target;
        }
    }
}

class Solution {

    public int solution(int[] costs, List<List<Integer>> graph, int target) {
        int[] indegree = getIndegree(graph);

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int[] cumulatedCosts = new int[costs.length];

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cumulatedCosts[cur] < costs[cur]) {
                cumulatedCosts[cur] = costs[cur];
            }

            for (Integer nextNode : graph.get(cur)) {
                if (cumulatedCosts[nextNode] < cumulatedCosts[cur] + costs[nextNode]) {
                    cumulatedCosts[nextNode] = cumulatedCosts[cur] + costs[nextNode];
                }
                indegree[nextNode]--;
                if(indegree[nextNode] == 0) q.offer(nextNode);
            }
        }

        return cumulatedCosts[target];
    }

    private int[] getIndegree(List<List<Integer>> graph) {
        int len = graph.size();
        int[] indegree = new int[len];
        for (int i = 1; i < len; i++) {
            List<Integer> fromNode = graph.get(i);
            for (Integer nextNode : fromNode) {
                indegree[nextNode]++;
            }
        }
        return indegree;
    }
}