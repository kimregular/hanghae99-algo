package p2407;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.n, ip.r));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int[] tokens = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return new Input(tokens[0], tokens[1]);
    }

    private static class Input {

        long n;
        long r;

        public Input(long n, long r) {
            this.n = n;
            this.r = r;
        }
    }
}

class Solution {

    public BigInteger solution(long n, long r) {
        return factorialOf(n).divide((factorialOf(n - r).multiply(factorialOf(r))));
    }

    private BigInteger factorialOf(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = n; i >= 1; i--) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}