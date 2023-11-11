package p24484;

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
    int[] orders;
    int order = 1;

    public GraphExplorer(int numOfNodes) {
        this.graph = new ArrayList<>();
        for (int i = 0; i < numOfNodes + 1; i++) {
            graph.add(new ArrayList<>());
        }
        this.isVisited = new int[numOfNodes+1];
        Arrays.fill(isVisited, -1);
        this.orders = new int[numOfNodes+1];
    }

    public void connect(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public long explore(int startNode) {
        long result = 0;
        DFS(startNode, 0);

        for (int i = 1; i < isVisited.length; i++) {
            if (isVisited[i] != -1) {
                result += (long) orders[i] * isVisited[i];
            }
        }
        return result;
    }

    private void DFS(int startNode, int depth) {
        isVisited[startNode] = depth;
        orders[startNode] = order++;

        for (int nextNode : graph.get(startNode)) {
            if(isVisited[nextNode] != -1) continue;
            DFS(nextNode, depth + 1);
        }
    }
}