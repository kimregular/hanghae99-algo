package p2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] arr = new int[9];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            Arrays.sort(arr);

            int fakeOne = 0;
            int fakeTow = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if (sum - arr[i] - arr[j] == 100) {
                        fakeOne = arr[i];
                        fakeTow = arr[j];
                        break;
                    }
                }
            }

            for (int i : arr) {
                if (i == fakeOne || i == fakeTow) {
                    continue;
                }
                System.out.println(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
