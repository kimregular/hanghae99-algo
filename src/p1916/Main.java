package p1916;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfCities = Integer.parseInt(br.readLine());
            int numOfBus = Integer.parseInt(br.readLine());

            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < numOfCities + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < numOfBus; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(from).add(new Edge(to, cost));
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startFrom = Integer.parseInt(st.nextToken());
            int startEnd = Integer.parseInt(st.nextToken());

            Solution s = new Solution(graph);
            System.out.println(s.getDis(startFrom, startEnd));

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

    public int getDis(int startFrom, int startEnd) {
        solution(startFrom);
        return this.dis[startEnd];
    }

    private void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        this.dis[v] = 0;

        while (!pQ.isEmpty()) {
            Edge currentCity = pQ.poll();

            if(currentCity.cost > this.dis[currentCity.vex]) continue;

            for (Edge nextCity : this.graph.get(currentCity.vex)) {
                if (this.dis[nextCity.vex] > currentCity.cost + nextCity.cost) {
                    this.dis[nextCity.vex] = currentCity.cost + nextCity.cost;
                    pQ.offer(new Edge(nextCity.vex, currentCity.cost + nextCity.cost));
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