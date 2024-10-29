package p1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        int[][] map = new int[len][len];

        for (int i = 0; i < len; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < map[i].length; j++) {
                if(tokens[j].equals("Y")) map[i][j] = 1;
                else if (i == j) map[i][j] = 0;
                else map[i][j] = len * len;
            }
        }
        return map;
    }
}

class Solution {

    public int solution(int[][] map) {
        int len = map.length;

        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        return getAnswer(map);
    }

    private int getAnswer(int[][] map) {
       int answer = 0;

        for (int[] person : map) {
            int cnt = 0;
            for (int friend : person) {
                if(friend == 1 || friend == 2) cnt++;
            }
            if(answer < cnt) answer = cnt;
        }
        return answer;
    }
}