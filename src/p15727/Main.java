package p15727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Long.parseLong(br.readLine());

        if (num % 5 >= 1) {
            System.out.println(num / 5 + 1);
        } else {
            System.out.println(num / 5);

        }

        br.close();
    }
}
