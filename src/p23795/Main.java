package p23795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long money;
    static long result;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (flag) {
            money = Long.parseLong(br.readLine());
            if (money == -1) {
                flag = false;
                break;
            }

            result += money;
        }


        System.out.println(result);
        br.close();
    }
}
