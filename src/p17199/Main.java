package p17199;

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

    private static List<List<Integer>> connect(List<List<Integer>> network, BufferedReader br) throws IOException {
        for (int node = 0; node < network.size() - 2; node++) {
            String[] tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            network.get(to).add(from);
        }
        return network;
    }

    private static List<List<Integer>> getNetwork(int len) {
        List<List<Integer>> network = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            network.add(new ArrayList<>());
        }
        return network;
    }
}

class Solution {

    public int solution(List<List<Integer>> network) {
        Calculator c = new Calculator(network);
        return c.getResult();
    }

    private class Calculator {

        List<List<Integer>> network;
        boolean[] isVisited;
        int startNode;
        int isAllConnected = -1;

        public Calculator(List<List<Integer>> network) {
            this.network = network;
        }

        public int getResult() {
            explore();
            return isAllConnected;
        }

        private void explore() {
            for (int i = 1; i < network.size(); i++) {
                if(isAllConnected != -1) break;
                startNode = i;
                isVisited = new boolean[network.size()];
                DFS(i);
            }
        }

        private void DFS(int start) {
            isVisited[start] = true;

            if (check()) {
                isAllConnected = startNode;
                return;
            }

            for (int nextNode : network.get(start)) {
                if(isVisited[nextNode]) continue;
                isVisited[nextNode] = true;
                DFS(nextNode);
            }
        }

        private boolean check() {
            for (int i = 1; i < isVisited.length; i++) {
                if(!isVisited[i]) return isVisited[i];
            }
            return true;
        }
    }
}
