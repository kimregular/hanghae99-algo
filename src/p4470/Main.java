package p4470;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p4470/test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String tmp = br.readLine();
            System.out.println(i+1 + ". " + tmp);
        }

        br.close();
    }
}
