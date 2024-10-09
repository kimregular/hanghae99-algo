package p12871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br), readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readInput(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

class Solution {

    public int solution(String str1, String str2) {
        int LCM = lcm(str1, str2);

        StringBuilder s1 = new StringBuilder(str1);
        StringBuilder s2 = new StringBuilder(str2);

        for (int i = 0; i < LCM / str1.length() - 1; i++) {
            s1.append(str1);
        }

        for (int i = 0; i < LCM / str2.length() - 1; i++) {
            s2.append(str2);
        }

        if (s1.toString().equals(s2.toString())) return 1;
        return 0;
    }

    private int lcm(String str1, String str2) {
        int a = Math.max(str1.length(), str2.length());
        int b = Math.min(str1.length(), str2.length());
        return (a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

