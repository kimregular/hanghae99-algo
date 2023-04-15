package p2441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;
    static String star = "*";

    static String blank = " ";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            System.out.println(blank.repeat(i)+star.repeat(num - i));
        }

        br.close();
    }
}
