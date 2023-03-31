package p2440;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        for (int i = num; i > 0; i--) {
            String st = "*".repeat(i);
            System.out.println(st);
        }

        br.close();
    }
}
