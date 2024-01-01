package p3009;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] Xs = new int[3];
            int[] Ys = new int[3];

            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                Xs[i] = x;
                Ys[i] = y;
            }

            Arrays.sort(Xs);
            Arrays.sort(Ys);

            System.out.println(findNum(Xs) + " " + findNum(Ys));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int findNum(int[] arr) {
        if (arr[0] == arr[1]) {
            return arr[2];
        } else {
            return arr[0];
        }
    }
}
