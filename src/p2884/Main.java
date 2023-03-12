package p2884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int hours;
    static int minutes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        hours = Integer.parseInt(st.nextToken());
        minutes = Integer.parseInt(st.nextToken());

        if (minutes - 45 < 0) {
            minutes = 60 - (45-minutes);
            hours--;
            if (hours < 0) {
                hours = 23;
            }
        } else {
            minutes -= 45;
        }

        System.out.println(hours + " " + minutes);

        br.close();
    }
}
