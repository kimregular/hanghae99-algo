package p11780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.cityMap, ip.nextCity));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine()) + 1;
        int[][] cityMap = new int[len][len];
        int[][] nextCity = new int[len][len];

        for (int i = 1; i < len; i++) {
            Arrays.fill(cityMap[i], 990_000_001);
            cityMap[i][i] = 0;
        }

        int busLines = Integer.parseInt(br.readLine());
        for (int i = 0; i < busLines; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (cityMap[from][to] > cost) {
                cityMap[from][to] = cost;
                nextCity[from][to] = to;
            }
        }
        return new Input(cityMap, nextCity);
    }

    private static class Input {
        private final int[][] cityMap;
        private final int[][] nextCity;

        public Input(int[][] cityMap, int[][] nextCity) {
            this.cityMap = cityMap;
            this.nextCity = nextCity;
        }
    }
}

class Solution {

    public String solution(int[][] map, int[][] nextCity) {

        int len = map.length;
        for (int k = 1; k < len; k++) {
            for (int i = 1; i < len; i++) {
                for (int j = 1; j < len; j++) {
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        nextCity[i][j] = nextCity[i][k];
                    }
                }
            }
        }

        return getAnswer(map, nextCity);
    }

    private String getAnswer(int[][] map, int[][] nextCity) {
        StringBuilder result = new StringBuilder();

        int len = map.length;
        // Output the cost matrix
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (map[i][j] == 990_000_001) result.append(0);
                else result.append(map[i][j]);
                result.append(" ");
            }
            result.append("\n");
        }

        // Output the paths
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (map[i][j] == 990_000_001 || i == j) {
                    result.append("0\n");
                } else {
                    List<Integer> path = getPath(nextCity, i, j);
                    result.append(path.size()).append(" ");
                    for (int city : path) {
                        result.append(city).append(" ");
                    }
                    result.append("\n");
                }
            }
        }

        return result.toString();
    }

    private List<Integer> getPath(int[][] nextCity, int i, int j) {
        List<Integer> path = new ArrayList<>();
        path.add(i);
        while (i != j) {
            i = nextCity[i][j];
            path.add(i);
        }
        return path;
    }
}
