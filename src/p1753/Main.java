package p1753;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfEdges = Integer.parseInt(st.nextToken());
            int numOfNodes = Integer.parseInt(st.nextToken());

            int start = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= numOfEdges; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < numOfNodes; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(from).add(new Edge(to, cost));
            }

            Solution s = new Solution(graph);
            int[] result = s.getDis(start);
            for (int i = 1; i < result.length; i++) {
                if (result[i] == Integer.MAX_VALUE) {
                    System.out.println("INF");
                } else {
                    System.out.println(result[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    ArrayList<ArrayList<Edge>> graph;
    int[] dis;

    public Solution(ArrayList<ArrayList<Edge>> graph) {
        this.graph = graph;
        this.dis = new int[graph.size()];
        Arrays.fill(this.dis, Integer.MAX_VALUE);
    }

    public int[] getDis(int v) {
        solution(v);
        return this.dis;
    }

    private void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        this.dis[v] = 0;

        while (!pQ.isEmpty()) {
            Edge currentEdge = pQ.poll();

            if(currentEdge.cost > this.dis[currentEdge.vex]) continue;

            for (Edge nextEdge : this.graph.get(currentEdge.vex)) {
                if (this.dis[nextEdge.vex] > currentEdge.cost + nextEdge.cost) {
                    this.dis[nextEdge.vex] = currentEdge.cost + nextEdge.cost;
                    pQ.offer(new Edge(nextEdge.vex, currentEdge.cost + nextEdge.cost));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {

    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}