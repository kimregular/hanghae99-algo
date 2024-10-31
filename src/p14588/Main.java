package p14588;

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
        int[][] result = new int[len + 1][2];

        for (int i = 1; i < len + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result[i][0] = start;
            result[i][1] = end;
        }
        return result;
    }

    private int[][] readQuestions(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][2];

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result[i][0] = start;
            result[i][1] = end;
        }
        return result;
    }
}

class Solution {

    public String solution(int[][] people, int[][] questions) {
        int len = people.length;

        int[][] relations = getRelations(people);

        for (int k = 1; k < len; k++) {
            for (int i = 1; i < len; i++) {
                for (int j = 1; j < len; j++) {
                    if (relations[i][j] > relations[i][k] + relations[k][j]) {
                        relations[i][j] = relations[i][k] + relations[k][j];
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int[] question : questions) {
            int from = question[0];
            int to = question[1];
            if(relations[from][to] == 0 || relations[from][to] == 999_999_999) answer.append(-1);
            else answer.append(relations[from][to]);
            answer.append("\n");
        }

        return answer.toString();
    }

    private int[][] getRelations(int[][] people) {
        int len = people.length;
        int[][] relations = new int[len][len];
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if(i == j) continue;
                if(isConnected(people[i], people[j])) relations[i][j] = 1;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if(i == j) continue;
                if(relations[i][j] == 0) relations[i][j] = 999_999_999;
            }
        }
        return relations;
    }

    private boolean isConnected(int[] target1, int[] target2) {
        return Math.max(target1[0], target2[0]) <= Math.min(target1[1], target2[1]);
    }
}