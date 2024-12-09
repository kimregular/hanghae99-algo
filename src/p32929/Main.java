package p32929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int target = readInput(br);

            if (target % 3 == 1) {
                System.out.println('U');
            } else if (target % 3 == 2) {
                System.out.println('O');
            } else {
                System.out.println('S');
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
