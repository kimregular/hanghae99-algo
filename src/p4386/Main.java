package p4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

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
        int len = Integer.parseInt(br.readLine());
        double[][] result = new double[len][2];
        for (int i = 0; i < len; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        }
        return result;
    }
}

class Solution {

    public double solution(double[][] coordinates) {
        List<double[]> stars = new ArrayList<>();

        int len = coordinates.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(i == j) continue;
                stars.add(new double[]{i + 1, j + 1, getDistance(coordinates[i], coordinates[j])});
            }
        }
        stars.sort(Comparator.comparing(a -> a[2]));

        int[] groups = IntStream.range(0, len + 1).toArray();

        double result = 0;
        for (double[] star : stars) {
            int from = (int) star[0];
            int to = (int) star[1];

            if (isConnected(groups, from, to)) {
                continue;
            }

            connect(groups, from, to);
            result += star[2];
        }
        return result;
    }

    private double getDistance(double[] star1, double[] star2) {
        double width = star2[1] - star1[1];
        double height = star2[0] - star1[0];
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    private boolean isConnected(int[] groups, int star1, int star2) {
        return getGroup(groups, star1) == getGroup(groups, star2);
    }

    private int getGroup(int[] groups, int target) {
        if(groups[target] != target) return groups[target] = getGroup(groups, groups[target]);
        return groups[target];
    }

    private void connect(int[] groups, int star1, int star2) {
        int g1 = getGroup(groups, star1);
        int g2 = getGroup(groups, star2);
        if (g1 != g2) {
            groups[Math.max(g1, g2)] = Math.min(g1, g2);
        }
    }

}