package p1485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        int testCases = Integer.parseInt(br.readLine());
        int[][] result = new int[testCases * 4][2];
        for (int i = 0; i < testCases * 4; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return result;
    }
}

class Solution {

    public String solution(int[][] testCases) {
        StringBuilder answer = new StringBuilder();
        int len = testCases.length;

        int cnt = 0;
        int[][] testCase = new int[4][2];
        for (int i = 0; i < len; i++) {
            testCase[cnt++] = testCases[i];
            if (cnt == 4) {
                answer.append(isSquare(testCase) ? 1 : 0).append("\n");
                cnt = 0;
                testCase = new int[4][2];
            }
        }
        return answer.toString();
    }

    private boolean isSquare(int[][] points) {
        Set<Double> lengthSet = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(i == j) continue;
                lengthSet.add(getLength(points[i], points[j]));
            }
        }
        return lengthSet.size() == 2;
    }

    private double getLength(int[] point1, int[] point2) {
        return Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2);
    }
}