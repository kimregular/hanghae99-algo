package p28014;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int prev = 0;
        int numOfPush = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] heightOfTowels = new int[len];
            for (int i = 0; i < len; i++) {
                int towel = Integer.parseInt(st.nextToken());
                heightOfTowels[i] = towel;
            }

            for (int towel : heightOfTowels) {
                if (prev <= towel) {
                    numOfPush += 1;
                }
                prev = towel;
            }
        System.out.println(numOfPush);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
