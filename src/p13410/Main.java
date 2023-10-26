package p13410;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int dan = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            int answer = 0;

            for (int i = 1; i < num + 1; i++) {
                int gugudan = dan * i;
                answer = Math.max(answer, reverseInt(gugudan));
            }
            System.out.println(answer);
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int reverseInt(int num) {
        char[] tmp = String.valueOf(num).toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tmp.length; i++) {
            result.append(tmp[tmp.length - 1 - i]);
        }

        return Integer.parseInt(result.toString());
    }
}
