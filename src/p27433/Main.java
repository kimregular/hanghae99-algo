package p27433;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int num;

    public static long fac(int num) {
        long result = 1;
        while (num >= 2) {
            result *= num;
            num--;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        System.out.println(fac(num));


        br.close();
    }
}
