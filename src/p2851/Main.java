package p2851;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] arr = new int[10];
            arr[0] = Integer.parseInt(br.readLine());
            for (int i = 1; i < arr.length; i++) {
                arr[i] = Integer.parseInt(br.readLine()) + arr[i - 1];
            }

            int answer = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 100) {
                    if (i == 0) {
                        answer = arr[i];
                        break;
                    }
                    int tmp1 = arr[i - 1];
                    int tmp2 = arr[i];
                    answer = getAnswer(tmp1, tmp2);
                    break;
                } else {
                    answer = arr[arr.length - 1];
                }
            }
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getAnswer(int num1, int num2) {
        int abs1 = Math.abs(100 - num1);
        int abs2 = Math.abs(100 - num2);

        if(abs1 > abs2) return num2;
        else if (abs1 == abs2) return num2;
        return num1;
    }
}
