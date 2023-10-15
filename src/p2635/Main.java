package p2635;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());
            List<Integer> arr = new ArrayList<>();

            int maxLen = 0;
            List<Integer> maxArr = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                arr.clear();
                arr.add(num);
                arr.add(i);

                while (true) {
                    int a = arr.get(arr.size() - 2);
                    int b = arr.get(arr.size() - 1);

                    if (a - b < 0) break;
                    arr.add(a - b);
                }

                if (arr.size() >= maxLen) {
                    maxLen = arr.size();
                    maxArr = new ArrayList<>(arr);
                }
//                System.out.println(i);
//                System.out.println(arr);
//                System.out.println();
            }

            System.out.println(maxLen);
            for (int x : maxArr) {
                System.out.print(x + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
