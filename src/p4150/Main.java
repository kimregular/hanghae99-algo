package p4150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int LEN = Integer.parseInt(br.readLine());

            Fibo fb = new Fibo(LEN);
            System.out.println(fb.createFibo(LEN));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Fibo {

    BigInteger[] fibo;

    public Fibo(int LEN) {
        this.fibo = new BigInteger[LEN + 1];
    }

    public BigInteger createFibo(int n) {
        if (n < 2) {
            return fibo[n] =  BigInteger.valueOf(n);
        }
        if (fibo[n] != null) {
            return fibo[n];
        }
        else return fibo[n] = createFibo(n - 2).add(createFibo(n - 1));
    }
}
