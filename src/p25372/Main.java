package p25372;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int nums;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("src/p25372/text.txt"));

        nums = Integer.parseInt(br.readLine());
        for (int i = 0; i < nums; i++) {
            String[] str = br.readLine().split("");

            if (str.length >= 6 && str.length <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        br.close();
    }
}
