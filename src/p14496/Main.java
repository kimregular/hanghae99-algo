package p14496;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.start, ip.target, ip.network));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int[] startAndTarget = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nodeAndLink = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = startAndTarget[0];
        int target = startAndTarget[1];

        int node = nodeAndLink[0];
        int link = nodeAndLink[1];

        List<List<Integer>> network = connect(br, getNetwork(node), link);

        return new Input(start, target, network);
    }

    private static List<List<Integer>> connect(BufferedReader br, List<List<Integer>> network, int numOfLinks) throws IOException {
        for (int i = 0; i < numOfLinks; i++) {
            int[] fromAndTo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = fromAndTo[0];
            int to = fromAndTo[1];

            network.get(from).add(to);
            network.get(to).add(from);
        }
        return network;
    }

    private static List<List<Integer>> getNetwork(int numOfNodes) {
        List<List<Integer>> network = new ArrayList<>();
        for (int i = 0; i <= numOfNodes; i++) {
            network.add(new ArrayList<>());
        }
        return network;
    }

    private static class Input{
        int start;
        int target;
        List<List<Integer>> network;

        public Input(int start, int target, List<List<Integer>> network) {
            this.start = start;
            this.target = target;
            this.network = network;
        }
    }
}

class Solution {

    public int solution(int start, int target, List<List<Integer>> network) {
        Calculator c = new Calculator(start, target, network);
        return c.getResult();
    }

    private class Calculator {

        int start;
        int target;
        List<List<Integer>> network;
        boolean[] isVisited;

        public Calculator(int start, int target, List<List<Integer>> network) {
            this.start = start;
            this.target = target;
            this.network = network;
            this.isVisited = new boolean[network.size()];
        }

        public int getResult() {
            return BFS();
        }

        private int BFS() {
            Queue<Change> q = new ArrayDeque<>();
            q.offer(new Change(start, 0));
            isVisited[start] = true;

            while (!q.isEmpty()) {
                Change currentChange = q.poll();
                int currentWord = currentChange.word;

                if(currentWord == target) return currentChange.numOfChanges;

                for (int nextWord : network.get(currentWord)) {
                    if(isVisited[nextWord]) continue;

                    isVisited[nextWord] = true;
                    q.offer(new Change(nextWord, currentChange.numOfChanges + 1));
                }
            }
            return -1;
        }

        private class Change{
            int word;
            int numOfChanges;

            public Change(int word, int numOfChanges) {
                this.word = word;
                this.numOfChanges = numOfChanges;
            }
        }
    }
}



























