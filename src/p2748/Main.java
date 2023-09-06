package p2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int NUM = Integer.parseInt(br.readLine());


            FiboMaker fm = new FiboMaker(NUM);
            fm.createFibo(NUM);
            System.out.println(fm.fibo[NUM]);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class FiboMaker {

    long[] fibo;

    public FiboMaker(int n) {
        this.fibo = new long[n + 1];
    }


    public long createFibo(int n) {
        if(fibo[n] != 0) return fibo[n];
        if(n < 2) return fibo[n] = n;
        else return fibo[n] = createFibo(n - 2) + createFibo(n - 1);
    }
}
