package p2444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    static void getStarts(int num) {
        String star = "*";
        String empty = " ";
        String stars;
        String empties;

        for (int i = 0; i < num; i++) {
            stars = star.repeat(2 * i + 1);
            empties = empty.repeat(num - 1 - i);
            System.out.println(empties+stars);
        }
        for (int i = num-2; i >= 0; i--) {
            stars = star.repeat(2 * i + 1);
            empties = empty.repeat(num - i - 1);
            System.out.println(empties+stars);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        getStarts(num);

        br.close();
    }
}
