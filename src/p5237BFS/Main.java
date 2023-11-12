package p5237BFS;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int numOfSites = Integer.parseInt(st.nextToken());
                GraphExplorer ge = new GraphExplorer(numOfSites);

                int numOfNodes = Integer.parseInt(st.nextToken());
                for (int j = 0; j < numOfNodes; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    ge.connectSite(x, y);
                }

                if (ge.isAllConnected()) {
                    System.out.println("Connected.");
                } else {
                    System.out.println("Not connected.");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class GraphExplorer {

    ArrayList<ArrayList<Integer>> graph;

    boolean[] isConnected;
    public GraphExplorer(int numOfNodes) {
        this.graph = new ArrayList<>();
        for (int i = 0; i < numOfNodes; i++) {
            graph.add(new ArrayList<>());
        }
        this.isConnected = new boolean[numOfNodes];
    }

    public void connectSite(int x, int y) {
        this.graph.get(x).add(y);
        this.graph.get(y).add(x);
    }

    public boolean isAllConnected() {
        checkConnection();
        for (int i = 0; i < isConnected.length; i++) {
            if (!isConnected[i]) {
                return false;
            }
        }
        return true;
    }

    private void checkConnection() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        isConnected[0] = true;

        while (!q.isEmpty()) {
            int currentSite = q.poll();

            for (Integer neighborSite : graph.get(currentSite)) {
                if (!isConnected[neighborSite]) {
                    isConnected[neighborSite] = true;
                    q.offer(neighborSite);
                }
            }
        }
    }
}