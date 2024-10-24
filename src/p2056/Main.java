package p2056;

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

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.costs, ip.graph));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());

        int[] costs = new int[len + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < len + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int cost = Integer.parseInt(st.nextToken());
            costs[i + 1] = cost;

            int repeat = Integer.parseInt(st.nextToken());

            for (int j = 0; j < repeat; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph.get(value).add(i + 1);
            }
        }
        return new Input(costs, graph);
    }

    private static class Input {
        private final int[] costs;
        private final List<List<Integer>> graph;

        public Input(int[] costs, List<List<Integer>> graph) {
            this.costs = costs;
            this.graph = graph;
        }
    }
}

class Solution {

    public int solution(int[] costs, List<List<Integer>> graph) {
        int[] indegree = getIndegree(graph);
        int[] dp = Arrays.copyOf(costs, costs.length);

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < costs.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer next : graph.get(cur)) {
                if (dp[next] < dp[cur] + costs[next]) {
                    dp[next] = dp[cur] + costs[next];
                }
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if(max < dp[i]) max = dp[i];
        }
        return max;
    }

    private int[] getIndegree(List<List<Integer>> graph) {
        int len = graph.size();
        int[] result = new int[len];

        for (int i = 1; i < len; i++) {
            List<Integer> node = graph.get(i);
            for (Integer next : node) {
                result[next]++;
            }
        }
        return result;
    }
}