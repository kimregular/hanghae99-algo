package p25191;

import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static StringTokenizer st;
    static int cola;
    static int beer;

    static int getNum(int num, int cola, int beer) {
        cola /= 2;
        int total = cola + beer;

        if (num >= total) {
            return total;
        } else {
            return num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        cola = Integer.parseInt(st.nextToken());
        beer = Integer.parseInt(st.nextToken());

        System.out.println(getNum(num, cola, beer));


        br.close();
    }
}
