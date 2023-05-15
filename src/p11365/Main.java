package p11365;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean flag = true;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p11365/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            String word = br.readLine();

            if (word.equals("END")) {
                flag = false;
                break;
            }
            StringBuffer sb = new StringBuffer(word);

            System.out.println(sb.reverse());

        }
        br.close();
    }
}
