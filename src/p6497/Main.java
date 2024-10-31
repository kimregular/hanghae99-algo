package p6497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            List<Input> inputs = readInput(br);
            Solution s = new Solution();
            for (Input input : inputs) {
                System.out.println(s.solution(input.numOfHouses, input.roads));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Input> readInput(BufferedReader br) throws IOException {
        List<Input> result = new ArrayList<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int numOfHouses = Integer.parseInt(st.nextToken());
            int numOfRoads = Integer.parseInt(st.nextToken());

            if(numOfHouses == 0 && numOfRoads == 0) break;

            int[][] roads = new int[numOfRoads][3];

            for (int i = 0; i < numOfRoads; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                roads[i][0] = from;
                roads[i][1] = to;
                roads[i][2] = cost;
            }

            result.add(new Input(numOfHouses, roads));
        }
        return result;
    }

    private static class Input{
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
        Arrays.sort(roads, Comparator.comparing(a -> a[2]));
        int[] group = IntStream.range(0, numOfHouses).toArray();
        int answer = 0;

        int origin = Arrays.stream(roads).mapToInt(a -> a[2]).sum();

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];

            if(isConnected(group, from, to)) continue;

            connect(group, from, to);

            answer += road[2];
        }
        return origin - answer;
    }

    private boolean isConnected(int[] group, int target1, int target2) {
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