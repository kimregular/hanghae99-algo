package p11404;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getCityMap(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getCityMap(BufferedReader br) throws IOException {
        int numOfCities = Integer.parseInt(br.readLine());

        int[][] cityMap = new int[numOfCities + 1][numOfCities + 1];

        for (int i = 1; i < cityMap.length; i++) {
            for (int j = 1; j < cityMap[i].length; j++) {
                cityMap[i][j] = (i == j) ? 0 : 990000001;
            }
        }
        int numOfBusLines = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfBusLines; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cityMap[from][to] = (cityMap[from][to] == 0) ? cost : Math.min(cityMap[from][to], cost);
        }

        return cityMap;
    }
}

class Solution {

    public String solution(int[][] cityMap) {
        return getAnswer(FW(cityMap));
    }

    private String getAnswer(int[][] cityMap) {
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i < cityMap.length; i++) {
            for (int j = 1; j < cityMap[i].length; j++) {
                if (cityMap[i][j] != 990000001) {
                    answer.append(cityMap[i][j]);
                } else {
                    answer.append(0);
                }
                answer.append(" ");
            }
            answer.append("\n");
        }

        return answer.toString();
    }
    private int[][] FW(int[][] cityMap) {

        for (int k = 1; k < cityMap.length; k++) {
            for (int i = 1; i < cityMap.length; i++) {
                for (int j = 1; j < cityMap.length; j++) {
                    if (i != j) {
                        cityMap[i][j] = Math.min(cityMap[i][j], cityMap[i][k] + cityMap[k][j]);
                    }
                }
            }
        }

        return cityMap;
    }
}