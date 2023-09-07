package p2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    int[] fibo;

    public Fibo(int LEN) {
        this.fibo = new int[LEN + 1];
    }

    public int createFibo(int n) {
        if(fibo[n] != 0) return fibo[n];
        if(n < 2) return fibo[n] = n;
        else return fibo[n] = createFibo(n - 2) + createFibo(n - 1);
    }
}