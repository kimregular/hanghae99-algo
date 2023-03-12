package p10808;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] result = new int[26];
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("src/p10808/text.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        for (char c : str) {
            result[c - 97] += 1;
        }

        for (int i : result) {
            answer.append(i).append(" ");
        }

        System.out.println(answer.toString());

        br.close();
    }
}
