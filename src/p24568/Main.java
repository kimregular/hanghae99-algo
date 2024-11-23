package p24568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] ints = readInput(br);
            int answer = 0;
            answer += ints[0] * 8;
            answer += ints[1] * 3;

            answer -= 28;

            System.out.println(answer);
            return;

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
