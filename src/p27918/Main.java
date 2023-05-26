package p27918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    static int x;
    static int y;

    static String who;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            who = br.readLine();
            if (Math.abs(x - y) >= 2) {
                break;
            } else {
                if ("D".equals(who)) {
                    x++;
                } else {
                    y++;
                }
            }
        }

        System.out.println(x + ":" + y);
        br.close();
    }
}
