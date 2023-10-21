package p11724BFS;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int numOfComponents = Integer.parseInt(st.nextToken());
            int numOfNodes = Integer.parseInt(st.nextToken());

            int[][] network = new int[numOfComponents + 1][numOfComponents + 1];

            for (int i = 0; i < numOfNodes; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                network[x][y] = 1;
                network[y][x] = 1;
            }

            ConnectedComponentFinder ccf = new ConnectedComponentFinder(network);
            System.out.println(ccf.getNumOfConnectedComponents());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ConnectedComponentFinder {

    int[][] network;
    boolean[] isChecked;

    public ConnectedComponentFinder(int[][] network) {
        this.network = network;
        this.isChecked = new boolean[network.length];
    }

    public int getNumOfConnectedComponents() {
        int numOfConnectedComponents = 0;

        for (int from = 1; from < network.length; from++) {
            for (int to = 1; to < network[from].length; to++) {
                if(!isChecked[from]){
                    explore(from);
                    numOfConnectedComponents++;
                }
            }
        }

        return numOfConnectedComponents;
    }

    private void explore(int from){
        Queue<Integer> q = new LinkedList<>();
        isChecked[from] = true;
        q.offer(from);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int currentComponents = q.poll();

                for (int target = 1; target < network[currentComponents].length; target++) {
                    if (network[currentComponents][target] == 1 && !isChecked[target]) {
                        isChecked[target] = true;
                        q.offer(target);
                    }
                }
            }
        }
    }
}