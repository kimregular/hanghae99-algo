package p13023;

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
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int numOfNodes = Integer.parseInt(tokens[1]);

        return connect(br, numOfNodes, getNetwork(len));
    }

    private static List<List<Integer>> getNetwork(int len) {
        List<List<Integer>> network = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            network.add(new ArrayList<>());
        }
        return network;
    }

    private static List<List<Integer>> connect(BufferedReader br, int numOfNodes, List<List<Integer>> network) throws IOException {
        for (int i = 0; i < numOfNodes; i++) {
            String[] tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            network.get(from).add(to);
            network.get(to).add(from);
        }
        return network;
    }
}

class Solution {

    public int solution(List<List<Integer>> network) {
        Calculator c = new Calculator(network);
        return c.getResult();
    }

    private class Calculator{

        List<List<Integer>> network;
        boolean[] isVisited;
        int result = 0;

        public Calculator(List<List<Integer>> network) {
            this.network = network;
            this.isVisited = new boolean[network.size()];
        }

        public int getResult() {
            for (int i = 0; i < network.size(); i++) {
                isVisited[i] = true;
                DFS(i, 0);
                isVisited[i] = false;
                if (result == 1) break;
            }
            return result;
        }

        private void DFS(int position, int cnt) {
            if (cnt == 4) {
                result = 1;
                return;
            }

            for (int nextFriend : network.get(position)) {
                if(isVisited[nextFriend]) continue;

                isVisited[nextFriend] = true;
                DFS(nextFriend, cnt + 1);
                isVisited[nextFriend] = false;
            }
        }
    }
}