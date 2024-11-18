package p11659;

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
            System.out.println(s.solution(ip.arr, ip.ranges));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int rangeLen = Integer.parseInt(tokens[1]);

        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] ranges = new int[rangeLen][2];
        for (int i = 0; i < rangeLen; i++) {
            tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            ranges[i][0] = from;
            ranges[i][1] = to;
        }

        return new Input(arr, ranges);
    }

    private static class Input {

        private final int[] arr;
        private final int[][] ranges;

        public Input(int[] arr, int[][] ranges) {
            this.arr = arr;
            this.ranges = ranges;
        }
    }
}

class Solution {

    public String solution(int[] arr, int[][] ranges) {
        int[] prefixSums = getPrefixSums(arr);

        StringBuilder answer = new StringBuilder();

        for (int[] range : ranges) {
            int from = range[0] - 1;
            int to = range[1];
            answer.append(prefixSums[to] - prefixSums[from]).append("\n");
        }
        return answer.toString();
    }

    private int[] getPrefixSums(int[] arr) {
        int len = arr.length;
        int[] prefixSums = new int[len + 1];

        for (int i = 1; i < len + 1; i++) {
            prefixSums[i] = prefixSums[i - 1] + arr[i - 1];
        }
        return prefixSums;
    }
}