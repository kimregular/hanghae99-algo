package p2741;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int num;

    public static void printNum(int num) {
        for (int i = 1; i < num + 1; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        printNum(num);
        br.close();
    }
}
