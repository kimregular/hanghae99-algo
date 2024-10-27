package p1197Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.numOfNodes, ip.infos));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int numOfNodes = Integer.parseInt(tokens[0]);
        int numOfLinks = Integer.parseInt(tokens[1]);

        int[][] result = new int[numOfLinks][3];

        for (int i = 0; i < numOfLinks; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            result[i][0] = from;
            result[i][1] = to;
            result[i][2] = cost;
        }

        return new Input(numOfNodes, result);
    }

    private static class Input {
        private final int numOfNodes;
        private final int[][] infos;

        public Input(int numOfNodes, int[][] infos) {
            this.numOfNodes = numOfNodes;
            this.infos = infos;
        }
    }
}

class Solution {

    public int solution(int numOfNodes, int[][] map) {
        Arrays.sort(map, Comparator.comparing(a -> a[2]));
        int sumOfWeight = 0;
        int cnt = 0;

        int[] group = groupInit(numOfNodes);

        for (int[] info : map) {
            if (cnt == numOfNodes - 1) break;
            int[] cur = info;
            int from = cur[0];
            int to = cur[1];
            if (isSameGroup(group, from, to)) continue;

            connect(group, from, to);
            sumOfWeight += cur[2];
            cnt++;
        }
        return sumOfWeight;
    }

    private int[] groupInit(int numOfNodes) {
        int[] group = new int[numOfNodes + 1];
        for (int i = 0; i < numOfNodes + 1; i++) {
            group[i] = i;
        }
        return group;
    }

    private boolean isSameGroup(int[] group, int target1, int target2) {
        return getGroup(group, target1) == getGroup(group, target2);
    }

    private int getGroup(int[] group, int target) {
        if(group[target] != target) return group[target] = getGroup(group, group[target]);
        // return getGroup(group, group[target]); 으로 하면 시간 초과
        return group[target];
    }

    private void connect(int[] group, int target1, int target2) {
        int group1 = getGroup(group, target1);
        int group2 = getGroup(group, target2);
        group[Math.max(group1, group2)] = Math.min(group1, group2);
    }
}
