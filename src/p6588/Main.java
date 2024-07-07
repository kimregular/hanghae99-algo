package p6588;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Integer> getInput(BufferedReader br) throws IOException {
        List<Integer> result = new ArrayList<>();
        int ip;
        while ((ip = Integer.parseInt(br.readLine())) != 0) {
            result.add(ip);
        }
        return result;
    }
}

class Solution {

    public String solution(List<Integer> targets) {
        Calculator c = new Calculator(targets, new Siever());
        return c.getResult();
    }

    private class Calculator {

        List<Integer> targets;
        boolean[] primeField;

        public Calculator(List<Integer> targets, Siever siever) {
            this.targets = targets;
            this.primeField = siever.getPrimeField();
        }

        public String getResult() {
            StringBuilder result = new StringBuilder();
            for (int target : targets) {
                result.append(calc(target)).append("\n");
            }
            return result.toString();
        }

        private String calc(int target) {
            int a = 100_000;
            int b = 0;

            for (int i = target; i >= 2; i--) {
                if (!primeField[i] && !primeField[target - i]) {
                    a = target - i;
                    b = i;
                    break;
                }
            }

            if (a == 100_000 && b == 0) {
                return "Goldbach's conjecture is wrong.";
            }
            return target + " = " + a + " + " + b;
        }
    }

    private class Siever {

        final boolean[] primeField = new boolean[1_000_001];

        public Siever() {
            sieve();
        }

        private void sieve() {
            primeField[0] = true;
            primeField[1] = true;
            for (int i = 2; i <= Math.sqrt(primeField.length); i++) {
                if(primeField[i]) continue;

                for (int j = i * i; j < primeField.length; j += i) {
                    primeField[j] = true;
                }
            }
        }

        public boolean[] getPrimeField() {
            return primeField;
        }
    }
}