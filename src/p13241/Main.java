package p13241;

import java.io.*;
import java.util.*;

public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            System.out.println(s.solution(Math.max(n, m), Math.min(n, m)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public long solution(long n, long m) {
        return n * m / GCD(n, m);
    }

    private long GCD(long n, long m) {
        if(m == 0) return n;
        return GCD(m, n % m);
    }
}