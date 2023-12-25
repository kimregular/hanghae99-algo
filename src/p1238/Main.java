package p1238;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfTowns = Integer.parseInt(st.nextToken());
            int numOfRoads = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Edge>> graphGo = new ArrayList<>();
            ArrayList<ArrayList<Edge>> graphBack = new ArrayList<>();
            for (int i = 0; i < numOfTowns + 1; i++) {
                graphGo.add(new ArrayList<>());
                graphBack.add(new ArrayList<>());
            }
            for (int i = 0; i < numOfRoads; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graphGo.get(from).add(new Edge(to, cost));
                graphBack.get(to).add(new Edge(from, cost));
            }

            Solution s = new Solution(graphGo, graphBack);
            System.out.println(s.getLongestDis(destination));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    ArrayList<ArrayList<Edge>> graphGo;
    ArrayList<ArrayList<Edge>> graphBack;

    int[] disGo;
    int[] disBack;

    public Solution(ArrayList<ArrayList<Edge>> graphGo, ArrayList<ArrayList<Edge>> graphBack) {
        this.graphGo = graphGo;
        this.graphBack = graphBack;
        this.disGo = new int[graphGo.size()];
        this.disBack = new int[graphGo.size()];
        Arrays.fill(this.disGo, Integer.MAX_VALUE);
        Arrays.fill(this.disBack, Integer.MAX_VALUE);
    }

    public int getLongestDis(int start) {
        solution(start, true);
        solution(start, false);
        int distance = 0;

        for (int i = 1; i < this.disGo.length; i++) {
            distance = Math.max(distance, this.disGo[i] + this.disBack[i]);
        }
        return distance;
    }

    private void solution(int start, boolean flag) {
        ArrayList<ArrayList<Edge>> graph;
        int[] dis;
        if (flag) {
            graph = this.graphGo;
            dis = this.disGo;
        } else {
            graph = this.graphBack;
            dis = this.disBack;
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start, 0));
        dis[start] = 0;

        while (!pQ.isEmpty()) {
            Edge currentTown = pQ.poll();

            if (currentTown.cost > dis[currentTown.vex]) continue;
            for (Edge nextTown : graph.get(currentTown.vex)) {
                if (dis[nextTown.vex] > currentTown.cost + nextTown.cost) {
                    dis[nextTown.vex] = currentTown.cost + nextTown.cost;
                    pQ.offer(new Edge(nextTown.vex, currentTown.cost + nextTown.cost));
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