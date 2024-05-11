package p2581;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip[0], ip[1]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        return new int[]{start, end};
    }
}

class Solution{

    boolean[] numberField;

    public Solution() {
        this.numberField = sieve();
    }

    public String solution(int start, int end) {
        int sumResult = 0;
        int minResult = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if(numberField[i]) continue;
            sumResult += i;
            minResult = Math.min(minResult, i);
        }
        if(sumResult == 0) return "-1";
        StringBuilder answer = new StringBuilder();
        answer.append(sumResult).append("\n").append(minResult);
        return answer.toString();
    }

    private boolean[] sieve() {
        boolean[] field = new boolean[10_001];
        field[0] = true;
        field[1] = true;
        for (int i = 2; i < field.length; i++) {
            if(field[i]) continue;
            for (int j = i + i; j < field.length; j += i) {
                field[j] = true;
            }
        }
        return field;
    }
}
