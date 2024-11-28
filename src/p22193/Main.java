package p22193;

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

            BigInteger[] input = readInput(br);

            System.out.println(input[0].multiply(input[1]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BigInteger[] readInput(BufferedReader br) throws IOException {
        br.readLine();
        BigInteger[] result = new BigInteger[2];
        result[0] = new BigInteger(br.readLine());
        result[1] = new BigInteger(br.readLine());
        return result;
    }
}
