package p27294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int time;
    static int drink;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        drink = Integer.parseInt(st.nextToken());

        if (time >= 12 && time <= 16 && drink == 0) {
            System.out.println(320);
        } else {
            System.out.println(280);
        }
        br.close();
    }
}
