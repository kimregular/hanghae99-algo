package p15803;

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

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private double[][] readInput(BufferedReader br) throws IOException {
        double[][] result = new double[3][2];
        for (int i = 0; i < 3; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        }
        return result;
    }
}

class Solution {

    public String solution(double[][] points) {
        if (areCollinear(points[0], points[1], points[2])) return "WHERE IS MY CHICKEN?";
        return "WINNER WINNER CHICKEN DINNER!";
    }

    private boolean areCollinear(double[] p1, double[] p2, double[] p3) {
        return (p2[1] - p1[1]) * (p3[0] - p2[0]) == (p3[1] - p2[1]) * (p2[0] - p1[0]);
    }
}
