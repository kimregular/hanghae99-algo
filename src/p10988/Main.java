package p10988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] st;

    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = br.readLine().split("");

        for (int i = 0; i < st.length; i++) {
            if (!(st[i].equals(st[st.length - 1 - i]))) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        br.close();
    }
}
