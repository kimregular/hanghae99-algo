package p1264;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static String[] filter = {"a", "e", "i", "o", "u"};
    static String[] sen;
    static int result = 0;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p1264/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        while (true) {
            String str = br.readLine();
            if (str.equals("#")) {
                break;
            }

            sen = str.split("");

            for (String s : sen) {
                String tmp = s.toLowerCase();
                for (String fil : filter) {
                    if (fil.equals(tmp)) {
                        result++;
                    }
                }
            }
            System.out.println(result);
            result = 0;

        }




        br.close();
    }
}
