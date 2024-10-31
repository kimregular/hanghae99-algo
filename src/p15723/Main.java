package p15723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br), readQuestions(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[27][27];

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int to = st.nextToken().charAt(0) - 'a';
            result[from][to] = 1;
        }

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                if(i == j) continue;
                if(result[i][j] == 0) result[i][j] = 999_999;
            }
        }
        return result;
    }

    private int[][] readQuestions(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][2];

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int to = st.nextToken().charAt(0) - 'a';
            result[i][0] = from;
            result[i][1] = to;
        }
        return result;
    }
}

class Solution {

    public String solution(int[][] map, int[][] qs) {
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

        StringBuilder answer = new StringBuilder();
        for (int[] q : qs) {
            int from = q[0];
            int to = q[1];

            if (map[from][to] != 0 && map[from][to] != 999_999) {
                answer.append("T");
            } else {
                answer.append("F");
            }
            answer.append("\n");
        }

        return answer.toString();
    }
}
