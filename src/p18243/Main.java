package p18243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.numOfPeople, ip.network));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int numOfPeople = Integer.parseInt(tokens[0]);
        int numOfLinks = Integer.parseInt(tokens[1]);

        int[][] network = new int[numOfLinks][2];

        for (int i = 0; i < numOfLinks; i++) {
            network[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return new Input(numOfPeople, network);
    }

    private static class Input {
        private final int numOfPeople;
        private final int[][] network;

        public Input(int numOfPeople, int[][] network) {
            this.numOfPeople = numOfPeople;
            this.network = network;
        }
    }
}

class Solution {

    private final int INF = 999_999;

    public String solution(int numOfPeople, int[][] network) {
        int[][] map = getMap(numOfPeople, network);

        int len = map.length;

        for (int k = 1; k < len; k++) {
            for (int i = 1; i < len; i++) {
                for (int j = 1; j < len; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        return isBigWorld(map) ? "Big World!" : "Small World!";
    }

    private int[][] getMap(int numOfPeople, int[][] network) {
        int[][] result = new int[numOfPeople + 1][numOfPeople + 1];
        int len = result.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(i == j) continue;
                result[i][j] = INF;
            }
        }

        for (int[] info : network) {
            int from = info[0];
            int to = info[1];
            result[from][to] = 1;
            result[to][from] = 1;
        }

        return result;
    }

    private boolean isBigWorld(int[][] map) {
        int len = map.length;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if(map[i][j] > 6) return true;
            }
        }
        return false;
    }
}