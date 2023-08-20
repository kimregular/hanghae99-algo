package p28701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());

            Solution s = new Solution();
            s.getNums(num);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public void getNums(int n) {
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            result += i;
        }

        System.out.println(result);

        System.out.println((int) Math.pow(result, 2));

        result = 0;

        for (int i = 1; i < n + 1; i++) {
            result += (int) Math.pow(i, 3);
        }

        System.out.println(result);
    }
}
