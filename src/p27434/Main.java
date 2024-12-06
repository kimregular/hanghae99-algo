package p27434;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(fact(1, readInput(br)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int readInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private BigInteger fact(int start, int target) {
        BigInteger temp = BigInteger.valueOf(start);

        if(start < target) {
            int b = (start + target) / 2;
            temp = fact(start, b).multiply(fact(b + 1, target));
        }
        return temp;
    }
}
