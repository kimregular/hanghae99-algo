package p1837;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String p = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            Solution s = new Solution(p, k);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    String p;
    int k;

    public Solution(String p, int k) {
        this.p = p;
        this.k = k;
    }

    public String solution() {
        for (int i = 2; i <= this.k; i++) {
            if (isPrime(i)) {
                if (isGood(i)) {
                    return "BAD " + i;
                }
            }
        }
        return "GOOD";
    }

    private boolean isGood(int i) {
        int tmp = 0;
        for (char x : this.p.toCharArray()) {
            tmp = (tmp * 10 + (x - '0')) % i;
        }
        return tmp == 0;
    }

    private boolean isPrime(int num) {
        if(num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}