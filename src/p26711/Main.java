package p26711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static BigInteger num1;
    public static BigInteger num2;
    public static BigInteger result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num1 = new BigInteger(br.readLine());
        num2 = new BigInteger(br.readLine());

        result = num1.add(num2);

        System.out.println(result);


        br.close();
    }
}
