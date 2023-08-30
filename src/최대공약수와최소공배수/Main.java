package 최대공약수와최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Solution s = new Solution();
            System.out.println(Arrays.toString(s.solution(n, m)));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int[] solution(int n, int m) {
        int bigger = Math.max(n, m);
        int smaller = Math.min(n, m);
        return new int[] {GCD(bigger, smaller), LCM(bigger, smaller)};
    }

    private int GCD(int n, int m) {
        if(n % m == 0) return m;
        return GCD(m, n % m);
    }

    private int LCM(int n, int m) {
        int gcd = GCD(n, m);
        return (n * m / gcd);
    }
}