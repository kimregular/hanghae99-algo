package p10870_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TARGET = Integer.parseInt(br.readLine());

            Solution s = new Solution(TARGET);
            System.out.println(s.makeFibo(TARGET));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    int[] fibo;

    public Solution(int n) {
        this.fibo = new int[n + 1];
    }

    public int makeFibo(int n) {
        if(fibo[n] != 0) return fibo[n];
        if(n < 2) return fibo[n] = n;
        else return fibo[n] =  makeFibo(n - 2) + makeFibo(n - 1);
    }
}
