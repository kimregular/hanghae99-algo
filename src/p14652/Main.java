package p14652;

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

            int[] input = readInput(br);
            int height = input[0];
            int width = input[1];
            int target = input[2];

            int row = target / width;
            int col = target % width;

            System.out.println(row + " " + col);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] readInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
