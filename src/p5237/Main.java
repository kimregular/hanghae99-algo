package p5237;

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
    boolean[] isVisited;
    public GraphExplorer(int numOfSites) {
        this.graph = new ArrayList<>();
        for (int j = 0; j < numOfSites; j++) {
            this.graph.add(new ArrayList<>());
        }
        this.isVisited = new boolean[numOfSites];
    }
    public void connectSite(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }


    public boolean isAllConnected() {
        checkConnections(0);

        for (boolean v : isVisited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void checkConnections(int site) {
        isVisited[site] = true;
        for (Integer nextSite : graph.get(site)) {
            if (!isVisited[nextSite]) {
                checkConnections(nextSite);
            }
        }
    }
}