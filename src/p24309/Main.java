package p24309;

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
            System.out.println((input[1].subtract(input[2])).divide(input[0]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BigInteger[] readInput(BufferedReader br) throws IOException {
        BigInteger[] result = new BigInteger[3];
        result[0] = new BigInteger(br.readLine());
        result[1] = new BigInteger(br.readLine());
        result[2] = new BigInteger(br.readLine());
        return result;
    }
}
