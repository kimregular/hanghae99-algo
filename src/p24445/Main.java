package p24445;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int numOfNodes = Integer.parseInt(st.nextToken());
            GraphExplorer ge = new GraphExplorer(numOfNodes);
            int numOfEdges = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            for (int i = 0; i < numOfEdges; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                ge.connect(x, y);
            }

            for (ArrayList<Integer> ints : ge.graph) {
                ints.sort(Collections.reverseOrder());
            }

            System.out.println(ge.explore(startNode));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class GraphExplorer {

    ArrayList<ArrayList<Integer>> graph;
    int[] isVisited;

    public GraphExplorer(int numOfNodes) {
        this.graph = new ArrayList<>();
        for (int i = 0; i < numOfNodes + 1; i++) {
            this.graph.add(new ArrayList<>());
        }
        this.isVisited = new int[numOfNodes + 1];
    }
    public void connect(int x, int y) {
        this.graph.get(x).add(y);
        this.graph.get(y).add(x);
    }

    public String explore(int startNode) {
        StringBuilder result = new StringBuilder();
        BFS(startNode);
        for (int i = 1; i < isVisited.length; i++) {
            result.append(isVisited[i]).append("\n");
        }

        return result.toString();
    }

    private void BFS(int startNode) {
        int order = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        isVisited[startNode] = order++;

        while (!q.isEmpty()) {
            int currentNode = q.poll();

            for (Integer neighborNode : this.graph.get(currentNode)) {
                if (isVisited[neighborNode] == 0) {
                    q.offer(neighborNode);
                    isVisited[neighborNode] = order++;
                }
            }
        }

    }
}