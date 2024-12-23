package p11549;

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

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.target, ip.field));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        int target = Integer.parseInt(br.readLine());
        int[] field = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return new Input(target, field);
    }

    private static class Input {

        private final int target;
        private final int[] field;

        public Input(int target, int[] field) {
            this.target = target;
            this.field = field;
        }
    }
}

class Solution {

    public int solution(int target, int[] field) {
        int[] memo = new int[5];
        for (int i : field) {
            memo[i]++;
        }
        return memo[target];
    }
}