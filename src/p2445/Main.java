package p2445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    static void getStars(int num) {
        String star = "*";
        String empty = " ";

        for (int i = 0; i < num; i++) {
            String stars = star.repeat(i + 1);
            String empties = empty.repeat(num - i-1);
            System.out.println(stars + empties + empties + stars);
        }
        for (int i = num-1; i > 0; i--) {
            String stars = star.repeat(i);
            String empties = empty.repeat(num - i);
            System.out.println(stars + empties + empties + stars);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        getStars(num);

        br.close();
    }
}
