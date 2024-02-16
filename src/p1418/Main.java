package p1418;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.len, ip.target));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        return new Input(len, target);
    }
}

class Solution {

    public int solution(int len, int target) {
        int answer = 0;

        for (int i = 1; i <= len; i++) {
            if(getMaxFactorFactory(i) <= target) answer++;
        }

        return answer;
    }
    private int getMaxFactorFactory(int num) {
        if (isPrime(num)) {
            return num;
        }else{
            return getMaxFactor(num);
        }
    }

    private boolean isPrime(int num) {
        if(num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
    private int getMaxFactor(int num) {
        if(num == 1) return 1;

        int len = (int) Math.sqrt(num) + 1;
        int maxFactor = 0;

        for (int i = 2; i < len; i++) {
            while (num % i == 0) {
                if(maxFactor < i) maxFactor = i;
                num /= i;
            }
        }

        if (num != 1) {
            if(num > maxFactor) maxFactor = num;
        }

        return maxFactor;
    }
}

class Input {

    int len;
    int target;

    public Input(int len, int target) {
        this.len = len;
        this.target = target;
    }
}
