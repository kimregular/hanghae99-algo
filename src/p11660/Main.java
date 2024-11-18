package p11660;

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

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.print(s.solution(ip.field, ip.ranges));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int rangeLen = Integer.parseInt(tokens[1]);

        int[][] field = new int[len][len];
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ranges = new int[rangeLen][4];
        for (int i = 0; i < rangeLen; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                ranges[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return new Input(field, ranges);
    }

    private static class Input {
        private final int[][] field;
        private final int[][] ranges;

        public Input(int[][] field, int[][] ranges) {
            this.field = field;
            this.ranges = ranges;
        }
    }
}

class Solution {

    public String solution(int[][] field, int[][] ranges) {
        int[][] prefixField = getPrefixField(field);

        StringBuilder answer = new StringBuilder();
        for (int[] range : ranges) {
            int fromX = range[0] - 1;
            int fromY = range[1] - 1;
            int toX = range[2] - 1;
            int toY = range[3] - 1;

            int sum = prefixField[toX][toY];
            if (fromX > 0) sum -= prefixField[fromX - 1][toY];
            if (fromY > 0) sum -= prefixField[toX][fromY - 1];
            if (fromX > 0 && fromY > 0) sum += prefixField[fromX - 1][fromY - 1];

            answer.append(sum).append("\n");
        }
        return answer.toString();
    }

    private int[][] getPrefixField(int[][] field) {
        int len = field.length;
        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[i][j] = field[i][j];
                if (i > 0) result[i][j] += result[i - 1][j];
                if (j > 0) result[i][j] += result[i][j - 1];
                if (i > 0 && j > 0) result[i][j] -= result[i - 1][j - 1];
            }
        }
        return result;
    }
}
