package p11726;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Solution {

    public long solution(int number) {
        int[] field = new int[1001];
        field[1] = 1;
        field[2] = 2;
        for (int i = 3; i < field.length; i++) {
            field[i] = (field[i - 1] + field[i - 2]) % 10007;
        }

        return field[number];
    }
}