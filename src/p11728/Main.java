package p11728;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.arr1, ip.arr2));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        br.readLine();
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return new Input(arr1, arr2);
    }

    private static class Input {

        int[] arr1;
        int[] arr2;

        public Input(int[] arr1, int[] arr2) {
            this.arr1 = arr1;
            this.arr2 = arr2;
        }
    }
}

class Solution {

    StringBuilder result = new StringBuilder();

    public String solution(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0;
        int arr1p = 0;
        int arr2p = 0;

        while (arr1p < arr1.length && arr2p < arr2.length) {
            if (arr1[arr1p] > arr2[arr2p]) {
                merged[i++] = arr2[arr2p++];
            } else {
                merged[i++] = arr1[arr1p++];
            }
        }

        while (arr1p < arr1.length) {
            merged[i++] = arr1[arr1p++];
        }

        while (arr2p < arr2.length) {
            merged[i++] = arr2[arr2p++];
        }

        return getAnswer(merged);
    }

    private String getAnswer(int[] arr) {
        for (int i : arr) {
            result.append(i).append(" ");
        }
        return result.toString();
    }
}