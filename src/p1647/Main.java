package p1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.numOfHouses, ip.roads));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int numOfHouese = Integer.parseInt(tokens[0]);
        int numOfRoads = Integer.parseInt(tokens[1]);

        int[][] roads = new int[numOfRoads][3];

        for (int i = 0; i < numOfRoads; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            roads[i][0] = from;
            roads[i][1] = to;
            roads[i][2] = cost;
        }

        return new Input(numOfHouese, roads);
    }

    private static class Input {
        private final int numOfHouses;
        private final int[][] roads;

        public Input(int numOfHouses, int[][] roads) {
            this.numOfHouses = numOfHouses;
            this.roads = roads;
        }
    }
}

class Solution {

    public int solution(int numOfHouses, int[][] roads) {
        int[] group = IntStream.range(0, numOfHouses + 1).toArray();

        Arrays.sort(roads, Comparator.comparing(a -> a[2]));

        int max = 0;
        int answer = 0;
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];

            if(isGroup(group, from, to)) continue;
            connect(group, from, to);

            int cost = road[2];
            answer += cost;
            if(max < cost) max = cost;
        }

        return answer - max;
    }

    private boolean isGroup(int[] group, int target1, int target2) {
        return getGroup(group, target1) == getGroup(group, target2);
    }

    private int getGroup(int[] group, int target) {
        if(target != group[target]) group[target] = getGroup(group, group[target]);
        return group[target];
    }

    private void connect(int[] group, int target1, int target2) {
        int g1 = getGroup(group, target1);
        int g2 = getGroup(group, target2);
        if (g1 != g2) {
            group[Math.max(g1, g2)] = Math.min(g1, g2);
        }
    }
}