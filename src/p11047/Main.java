package p11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.target, ip.coins));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input getInput(BufferedReader br) throws IOException {
        String[] st = br.readLine().split(" ");

        int numOfCoins = Integer.parseInt(st[0]);
        int target = Integer.parseInt(st[1]);

        int[] coins = new int[numOfCoins];

        for (int i = 0; i < numOfCoins; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        return new Input(target, coins);
    }

    private static class Input {

        private final int target;
        private final int[] coins;

        public Input(int target, int[] coins) {
            this.target = target;
            this.coins = coins;
        }
    }

}

class Solution {

    public int solution(int target, int[] coins) {
        int answer = 0;

        int len = coins.length;
        for (int i = 0; i < len; i++) {
            if(target < coins[len - i - 1]) continue;
            answer += target / coins[len - i - 1];
            target %= coins[len - i - 1];
        }
        return answer;
    }
}

