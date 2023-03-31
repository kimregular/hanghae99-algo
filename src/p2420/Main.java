package p2420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long num1;
    static long num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        num1 = Integer.parseInt(st[0]);
        num2 = Integer.parseInt(st[1]);

        System.out.println(Math.abs(num1 - num2));

        br.close();
    }
}
