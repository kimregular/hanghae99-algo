package p10826;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                System.out.println(0);
                return;
            }
            BigInteger[] arr = new BigInteger[num + 1];
            arr[0] = BigInteger.ZERO;
            arr[1] = BigInteger.ONE;
            for (int i = 2; i < arr.length; i++) {
                BigInteger tmp1 = arr[i - 1];
                BigInteger tmp2 = arr[i - 2];
                arr[i] = tmp1.add(tmp2);
            }

            System.out.println(arr[arr.length - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
