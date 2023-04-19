package p2506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int num;

    static String tmp;

    static int score;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            tmp = st.nextToken();
            if (tmp.equals("1")) {
                score++;
            } else {
                score = 0;
            }

            result += score;
        }

        System.out.println(result);

        br.close();
    }
}
