package SW1945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Calculator s = new Calculator();
            System.out.println(s.solve(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] inputs = new int[len];

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        return inputs;
    }
}

class Calculator {

    public String solve(int[] inputs) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < inputs.length; i++) {
            answer.append("#").append(i + 1).append(" ").append(calc(inputs[i])).append("\n");
        }
        return answer.toString();
    }

    private String calc(int num) {
        StringBuilder result = new StringBuilder();
        int[] primes = {2, 3, 5, 7, 11};

        for (int prime : primes) {
            int cnt = 0;
            while (num % prime == 0) {
                cnt++;
                num /= prime;
            }
            result.append(cnt).append(" ");
        }
        return result.toString();
    }
}