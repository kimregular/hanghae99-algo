package p14916;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(br.readLine());

            Solution s = new Solution();
            System.out.println(s.getCoins(target));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int[] coins = {2, 5};

    public int getCoins(int target) {
        int[] numOfCoins = new int[target + 1];
        Arrays.fill(numOfCoins, target + 1);
        numOfCoins[0] = 0;

        for (int coin : this.coins) {
            for (int i = coin; i < numOfCoins.length; i++) {
                numOfCoins[i] = Math.min(numOfCoins[i], numOfCoins[i - coin] + 1);
            }
        }

        if(numOfCoins[target] == target+1) return -1;
        return numOfCoins[target];
    }
}