package p3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int LEN = 9;

            int[] arr = new int[LEN];
            for (int i = 0; i < LEN; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Solution s = new Solution(arr);
            s.getFakers();
            s.getDwarves();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    final int NUM = 100;
    int fakeOne;
    int fakeTwo;
    int[] arr;

    public Solution(int[] arr) {
        this.arr = arr;
    }

    public void getFakers() {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == NUM) {
                    fakeOne = arr[i];
                    fakeTwo = arr[j];
                    return;
                }
            }
        }
    }

    public void getDwarves() {
        for (int i : arr) {
            if (i != fakeOne && i != fakeTwo) {
                System.out.println(i);
            }
        }
    }
}