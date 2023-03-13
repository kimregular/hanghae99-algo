package p5524;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num;
    static String[] name;

    public static void toLowerName(String[] name) {
        StringBuilder answer = new StringBuilder();
        for (String s : name) {
            answer.append(s.toLowerCase());
        }
        System.out.println(answer);

    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p5524/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            name = br.readLine().split(" ");
            toLowerName(name);
        }

        br.close();
    }
}
