package p2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int hours;
    static int minutes;
    static int time;

    static void timer(int hours, int minutes, int time) {
        int tmp = minutes + time;

        hours += tmp / 60;
        minutes = tmp % 60;

        if (hours >= 24) {
            hours -= 24;
        }
        System.out.println(hours + " " + minutes);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        hours = Integer.parseInt(st[0]);
        minutes = Integer.parseInt(st[1]);
        time = Integer.parseInt(br.readLine());

        timer(hours, minutes, time);


        br.close();
    }
}
