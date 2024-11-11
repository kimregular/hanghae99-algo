package p11256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        StringBuilder answer = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int testCases = Integer.parseInt(br.readLine());
            Solution s = new Solution();

            while (testCases-- > 0) {
                Input ip = readInput(br);
                answer.append(s.solution(ip.candies, ip.sizes)).append("\n");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(answer);
        return;
    }

    private Input readInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int candies = Integer.parseInt(tokens[0]);
        int len = Integer.parseInt(tokens[1]);
        int[][] sizes = new int[len][2];

        for (int i = 0; i < len; i++) {
            tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            sizes[i][0] = x;
            sizes[i][1] = y;
        }
        return new Input(candies, sizes);
    }

    private static class Input {

        private final int candies;
        private final int[][] sizes;

        public Input(int candies, int[][] sizes) {
            this.candies = candies;
            this.sizes = sizes;
        }
    }
}

class Solution {

    public int solution(int candies, int[][] sizes) {
        Arrays.sort(sizes, Comparator.comparingInt(a -> -(a[0] * a[1])));

        int answer = 0;

        for (int[] size : sizes) {
            if (candies <= 0) return answer;
            answer++;
            int x = size[0];
            int y = size[1];
            candies -= (x * y);
        }
        return answer;
    }
}