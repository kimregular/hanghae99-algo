package p2606;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numOfComputers = Integer.parseInt(br.readLine());
            int numOfNodes = Integer.parseInt(br.readLine());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= numOfComputers; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < numOfNodes; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                graph.get(num1).add(num2);
                graph.get(num2).add(num1);
            }

            DFSScanner ds = new DFSScanner(graph);
            ds.DFS(1);
            System.out.println(ds.answer-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class DFSScanner {

    ArrayList<ArrayList<Integer>> graph;
    boolean[] isVisited;
    int answer = 0;

    public DFSScanner(ArrayList<ArrayList<Integer>> graph) {
        this.graph = graph;
        isVisited = new boolean[graph.size() + 1];
    }

    public void DFS(int l){
        if(isVisited[l]) return;
        answer++;
        isVisited[l] = true;
        for(int i = 0; i < graph.get(l).size(); i++){
            DFS(graph.get(l).get(i));
        }
    }
}