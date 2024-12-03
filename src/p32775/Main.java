package p32775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] input = readInput(br);
            if (input[0] <= input[1]) {
                System.out.println("high speed rail");
            } else {
                System.out.println("flight");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] readInput(BufferedReader br) throws IOException {
        int[] result = new int[2];
        result[0] = Integer.parseInt(br.readLine());
        result[1] = Integer.parseInt(br.readLine());
        return result;
    }
}
