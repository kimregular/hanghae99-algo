package p2587;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[5];
        int total = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 5; i++) {
                int num = Integer.parseInt(br.readLine());
                arr[i] = num;
                total += num;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(total / 5);
        Arrays.sort(arr);
        System.out.println(arr[2]);

    }
}
