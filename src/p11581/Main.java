package p11581;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<Integer>> getInput(BufferedReader br) throws IOException {
        return connect(getNetwork(Integer.parseInt(br.readLine())), br);
    }

    private static List<List<Integer>> getNetwork(int len) {
        List<List<Integer>> network = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            network.add(new ArrayList<>());
        }
        return network;
    }

    private static List<List<Integer>> connect(List<List<Integer>> network, BufferedReader br) throws IOException {
        for (int node = 1; node < network.size() - 1; node++) {
            int len = Integer.parseInt(br.readLine());
            int[] destinations = new int[len];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < destinations.length; i++) {
                destinations[i] = Integer.parseInt(st.nextToken());
            }
            for (int dest : destinations) {
                network.get(node).add(dest);
            }
        }
        return network;
    }
}

class Solution {

    public String solution(List<List<Integer>> network) {
        Calculator c = new Calculator(network);
        return c.getResult();
    }

    private class Calculator {

        List<List<Integer>> network;
        boolean[] isVisited;
        boolean isCircular = false;

        public Calculator(List<List<Integer>> network) {
            this.network = network;
        }

        public String getResult() {
            explore();
            if(isCircular) return "CYCLE";
            return "NO CYCLE";
        }

        private void explore() {
            for (int start : network.get(1)) {
                if(isCircular) break;
                isVisited = new boolean[network.size()];
                DFS(start);
            }
        }

        private void DFS(int start) {
            isVisited[start] = true;
            for (int next : network.get(start)) {
                if (isVisited[next]) {
                    isCircular = true;
                    return;
                }
                DFS(next);
            }
            isVisited[start] = false;
        }
    }
}

