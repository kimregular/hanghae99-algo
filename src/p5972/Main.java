package p5972;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfCows = Integer.parseInt(st.nextToken());
            int numOfRoads = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Cow>> graph = new ArrayList<>();
            for (int i = 0; i < numOfCows + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < numOfRoads; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(from).add(new Cow(to, cost));
                graph.get(to).add(new Cow(from, cost));
            }

            Solution s = new Solution(graph);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    ArrayList<ArrayList<Cow>> graph;
    int[] distance;

    public Solution(ArrayList<ArrayList<Cow>> graph) {
        this.graph = graph;
        this.distance = new int[graph.size()];
        Arrays.fill(this.distance, Integer.MAX_VALUE);
    }

    public int solution() {
        DIJKSTRA(1);
        return this.distance[this.distance.length - 1];
    }

    private void DIJKSTRA(int i) {
        PriorityQueue<Cow> pQ = new PriorityQueue<>();
        pQ.offer(new Cow(i, 0));
        this.distance[i] = 0;

        while (!pQ.isEmpty()) {
            Cow currentCow = pQ.poll();

            if(currentCow.cost > this.distance[currentCow.pos]) continue;

            for (Cow nextCow : this.graph.get(currentCow.pos)) {
                if (this.distance[nextCow.pos] > currentCow.cost + nextCow.cost) {
                    this.distance[nextCow.pos] = currentCow.cost + nextCow.cost;
                    pQ.offer(new Cow(nextCow.pos, currentCow.cost + nextCow.cost));
                }
            }
        }
    }
}

class Cow implements Comparable<Cow> {
    int pos;
    int cost;

    public Cow(int pos, int cost) {
        this.pos = pos;
        this.cost = cost;
    }

    @Override
    public int compareTo(Cow other) {
        return this.cost - other.cost;
    }
}