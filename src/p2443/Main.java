package p2443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    static void getStar(int num) {
        String star = "*";
        String empty = " ";
        for (int i = num; i > 0; i--) {
            String stars = star.repeat(i * 2 - 1);
            String empties = empty.repeat(num - i);
            System.out.println(empties + stars);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        getStar(num);

        br.close();
    }
}
