package p21598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = readInput(br);
            for (int i = 0; i < n; i++) {
                System.out.println("SciComLove");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
