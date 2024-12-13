package p15439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Function<Integer, Integer> function = (a) -> {
                return a * (a - 1);
            };

            System.out.println(function.apply(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
