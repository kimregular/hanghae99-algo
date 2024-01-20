package p30664;

import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                BigInteger num = new BigInteger(br.readLine());

                if (num.equals(BigInteger.ZERO)) {
                    break;
                }

                if (BigInteger.ZERO.equals(num.remainder(BigInteger.valueOf(42)))) {
                    System.out.println("PREMIADO");
                } else {
                    System.out.println("TENTE NOVAMENTE");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
