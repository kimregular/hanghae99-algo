package p1629;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInputs(br)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[] getInputs(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        return new long[]{a, b, c};
    }
}

class Solution {

    public long solution(long[] abc) {
        long a = abc[0];
        long b = abc[1];
        long c = abc[2];

        return calc(a, b, c);
    }

    private long calc(long a, long b, long c) {
        if(b == 0) return 1;
        if(b == 1) return a%c;
        if (b % 2 == 0) {
            long tmp = calc(a, b / 2, c);
            return tmp * tmp % c;
        } else {
            long tmp = calc(a, (b - 1) / 2, c);
            long tmp2 = tmp * tmp % c;
            return (a * tmp2) % c;
        }
    }
}