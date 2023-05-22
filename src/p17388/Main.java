package p17388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    static int soong;
    static int korea;
    static int han;

    static void getUniv(int soong, int korea, int han) {
        if (soong + korea + han >= 100) {
            System.out.println("OK");
        } else {
            if (soong < korea && soong < han) {
                System.out.println("Soongsil");
            } else if (korea < soong && korea < han) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        soong = Integer.parseInt(st.nextToken());
        korea = Integer.parseInt(st.nextToken());
        han = Integer.parseInt(st.nextToken());

        getUniv(soong, korea, han);

        br.close();
    }
}
