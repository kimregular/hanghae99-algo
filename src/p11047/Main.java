package p11047;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);

            Solution s = new Solution();
            System.out.println(s.solution(ip.target, ip.coins));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] st = br.readLine().split(" ");

        int numOfCoins = Integer.parseInt(st[0]);
        int target = Integer.parseInt(st[1]);

        int[] coins = new int[numOfCoins];

        for (int i = 0; i < numOfCoins; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        return new Input(target, coins);
    }
}

class Solution {

    public int solution(int target, int[] coins) {
        int answer = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];

            if (coin <= target) {
                answer += target / coin;
                target %= coin;
            }

            if(target <= 0) break;
        }

        return answer;
    }
}

class Input {

    int target;
    int[] coins;

    public Input(int target, int[] coins) {
        this.target = target;
        this.coins = coins;
    }
}
