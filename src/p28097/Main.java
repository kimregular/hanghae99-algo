package p28097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int num;
    static int day;
    static int hour;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            day += Integer.parseInt(st.nextToken());
        }

        day += 8 * (num - 1);

        hour = day % 24;
        day /= 24;

        System.out.println(day + " " + hour);
        br.close();
    }
}
