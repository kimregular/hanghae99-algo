package p16398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return result;
    }
}

class Solution {

    public long solution(int[][] map) {
        List<Node> graph = new ArrayList<>();

        int len = map.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(i == j) continue;
                graph.add(new Node(i + 1, j + 1, map[i][j]));
            }
        }
        graph.sort(null);

        long result = 0L;
        int[] group = IntStream.range(0, len + 1).toArray();
        for (Node node : graph) {
            if(isConnected(group, node.from, node.to)) continue;

            connect(group, node.from, node.to);

            result += node.cost;
        }

        return result;
    }

    private boolean isConnected(int[] group, int target1, int target2) {
        return getGroup(group, target1) == getGroup(group, target2);
    }

    private int getGroup(int[] group, int target) {
        if(target != group[target]) group[target] = getGroup(group, group[target]);
        return group[target];
    }

    private void connect(int[] group, int target1, int target2){
        int g1 = getGroup(group, target1);
        int g2 = getGroup(group, target2);
        if (g1 != g2) {
            group[Math.max(g1, g2)] = Math.min(g1, g2);
        }
    }

    private static class Node implements Comparable<Node> {
        private final int from;
        private final int to;
        private final int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(cost, node.cost);
        }
    }
}