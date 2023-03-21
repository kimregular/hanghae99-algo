package p10798;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<List<String>> letters = new ArrayList<>();
    static int len = Integer.MIN_VALUE;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p10798/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            try {
                String[] tmp = br.readLine().split("");
                len = Math.max(len, tmp.length);
                letters.add(Arrays.asList(tmp));
            } catch (NullPointerException e) {
                flag = false;
            }
        }

        for (int i = 0; i < len; i++) {

            for (List<String> letter : letters) {
                try {
                    System.out.print(letter.get(i));
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }

        }

        br.close();
    }
}
