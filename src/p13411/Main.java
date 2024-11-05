package p13411;

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

    private int[][] readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] result = new int[len][3];
        for (int i = 0; i < len; i++) {
            result[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return result;
    }
}

class Solution {

    public String solution(int[][] coordinates) {
        int len = coordinates.length;
        Point[] points = new Point[len];

        for (int i = 0; i < coordinates.length; i++) {
            points[i] = new Point(i + 1, coordinates[i]);
        }

        Arrays.sort(points);

        StringBuilder answer = new StringBuilder();
        for (Point point : points) {
            answer.append(point.n).append("\n");
        }
        return answer.toString();
    }

    private static class Point implements Comparable<Point> {

        private final int n;
        private final int x;
        private final int y;
        private final int s;
        private final double v;

        public Point(int n, int[] info) {
            this.n = n;
            this.x = info[0];
            this.y = info[1];
            this.s = info[2];
            this.v = getOrder();
        }

        private double getOrder() {
            return getDistance() / s;
        }

        private double getDistance() {
            return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }

        @Override
        public int compareTo(Point o) {
            if (v == o.v) return Integer.compare(n, o.n);
            return Double.compare(v, o.v);
        }
    }
}
