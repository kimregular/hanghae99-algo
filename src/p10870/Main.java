package p10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TARGET = Integer.parseInt(br.readLine());

            Solution s = new Solution(TARGET);
            for (int i = 0; i < TARGET + 1; i++) {
                s.makeFibo(i);
            }
            System.out.println(s.fibo[TARGET]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    int[] fibo;

    public Solution(int num) {
        this.fibo = new int[num + 1];
    }

    public void makeFibo(int n) {
        if(n < 2)  fibo[n] = n;
        else fibo[n] = fibo[n - 2] + fibo[n - 1];
    }
}