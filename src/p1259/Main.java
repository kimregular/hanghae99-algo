package p1259;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean flag = true;

    static boolean isPalin(String[] st) {
        for (int i = 0; i < st.length; i++) {
            if (!(st[i].equals(st[st.length - 1 - i]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p1259/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (flag) {
            String[] st = br.readLine().split("");
            if (st[0].equals("0")) {
                flag = false;
                break;
            } else {
                if (isPalin(st)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }

        br.close();
    }
}
