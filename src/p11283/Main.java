package p11283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(readInput(br) - 44031);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private char readInput(BufferedReader br) throws IOException {
        return br.readLine().charAt(0);
    }
}
