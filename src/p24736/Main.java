package p24736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] score1 = readInput(br);
            int[] score2 = readInput(br);

            System.out.printf("%d %d", getTotalScore(score1), getTotalScore(score2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] readInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private int getTotalScore(int[] score) {
        int result = 0;
        result += score[0] * 6;
        result += score[1] * 3;
        result += score[2] * 2;
        result += score[3] * 1;
        result += score[4] * 2;
        return result;
    }
}
