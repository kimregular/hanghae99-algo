package p2576;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long total = 0;
    static long add = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p2576/text.txt"));

        for (int i = 0; i < 7; i++) {

            long tmp = Long.parseLong(br.readLine());
            if (tmp % 2 != 0) {
                total += tmp;
                add = Math.min(add, tmp);
            }

        }

        if (total == 0) {
            System.out.println(-1);
        } else {
            System.out.println(total);
            System.out.println(add);
        }


        br.close();
    }
}
