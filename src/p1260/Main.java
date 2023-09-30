package p1260;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int numOfNodes = Integer.parseInt(st.nextToken());
            int numOfEdges = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= numOfNodes; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < numOfEdges; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                graph.get(num1).add(num2);
                graph.get(num2).add(num1);
            }

            for(ArrayList<Integer> lst : graph){
                Collections.sort(lst);
            }

            DFSScanner ds = new DFSScanner(graph);
            ds.DFS(start);
            System.out.println();
            BFSScanner bs = new BFSScanner(graph, start);
            bs.BFS();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class DFSScanner {
    ArrayList<ArrayList<Integer>> graph;
    boolean[] isVisited;

    public DFSScanner(ArrayList<ArrayList<Integer>> graph) {
        this.graph = graph;
        this.isVisited = new boolean[graph.size()]; // 1부터 시작한다.
    }

    public void DFS(int start) {
        if (isVisited[start]) return;
        System.out.print(start + " ");
        isVisited[start] = true;

        for (int i = 0; i < graph.get(start).size(); i++) {
            DFS(graph.get(start).get(i));
        }
    }
}

class BFSScanner {
    ArrayList<ArrayList<Integer>> graph;
    int start;
    boolean[] isVisited;
    Queue<Integer> q = new LinkedList<>();

    public BFSScanner(ArrayList<ArrayList<Integer>> graph, int start) {
        this.graph = graph;
        this.start = start;
        this.isVisited = new boolean[graph.size()]; // 1부터 시작한다.
    }

    public void BFS() {
        q.offer(start);

        isVisited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for(int x : graph.get(node)){
                if(!isVisited[x]){
                    q.offer(x);
                    isVisited[x] = true;
                }
            }

        }
    }
}
