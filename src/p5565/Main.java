package p5565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long total;

    static Long tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        total = Long.parseLong(br.readLine());

        for (int i = 0; i < 9; i++) {
            tmp = Long.parseLong(br.readLine());
            total -= tmp;
        }

        System.out.println(total);

        br.close();
    }
}
