package p15740;

import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getInput(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
    }
}

class Solution {

    public BigInteger solution(String[] input) {
        BigInteger num1 = new BigInteger(input[0]);
        BigInteger num2 = new BigInteger(input[1]);
        return num1.add(num2);
    }
}