package p1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.graph, ip.visit1, ip.visit2));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int numOfNodes = Integer.parseInt(tokens[0]);
        int numOfLinks = Integer.parseInt(tokens[1]);

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= numOfNodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < numOfLinks; i++) {
            tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            int cost = Integer.parseInt(tokens[2]);
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }

        tokens = br.readLine().split(" ");
        int visit1 = Integer.parseInt(tokens[0]);
        int visit2 = Integer.parseInt(tokens[1]);

        return new Input(graph, visit1, visit2);
    }

    private static class Input {

        private final List<List<Edge>> graph;
        private final int visit1;
        private final int visit2;

        public Input(List<List<Edge>> graph, int visit1, int visit2) {
            this.graph = graph;
            this.visit1 = visit1;
            this.visit2 = visit2;
        }
    }
}

class Solution {

    private static final int INF =200_000_000;


    public int solution(List<List<Edge>> graph, int visit1, int visit2) {
        int result1 = getShortedPath(graph, visit1, visit2);
        int result2 = getShortedPath(graph, visit2, visit1);

        if (result1 >= INF && result2 >= INF) return -1;
        return Math.min(result1, result2);
    }

    private int getShortedPath(List<List<Edge>> graph, int visit1, int visit2) {
        int shortestPath = 0;
        shortestPath += calc(graph, 1, visit1);
        shortestPath += calc(graph, visit1, visit2);
        shortestPath += calc(graph, visit2, graph.size() - 1);
        return shortestPath;
    }

    private int calc(List<List<Edge>> graph, int start, int dest) {
        int[] dis = new int[graph.size()];
        Arrays.fill(dis, INF);
        boolean[] visit = new boolean[graph.size()];

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(start, 0));
        dis[start] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (visit[cur.to]) continue;
            visit[cur.to] = true;
            for (Edge nextEdge : graph.get(cur.to)) {
                if (dis[nextEdge.to] > cur.cost + nextEdge.cost) {
                    dis[nextEdge.to] = cur.cost + nextEdge.cost;
                    q.offer(new Edge(nextEdge.to, cur.cost + nextEdge.cost));
                }
            }
        }
        return dis[dest];
    }
}

class Edge implements Comparable<Edge> {

    final int to;
    final int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}