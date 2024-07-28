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
        MySort ms = new MySort(arr1, arr2);
        return getAnswer(ms.getSorted());
    }

    private String getAnswer(int[] arr) {
        for (int i : arr) {
            result.append(i).append(" ");
        }
        return result.toString();
    }
}

class MySort {

    int[] arr1;
    int[] arr2;
    int[] sorted;
    int arr1p = 0;
    int arr2p = 0;

    public MySort(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.sorted = new int[arr1.length + arr2.length];
    }

    public int[] getSorted() {
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = getSmaller();
        }
        return sorted;
    }

    private int getSmaller() {
        int arr1Target = Integer.MIN_VALUE;
        int arr2Target = Integer.MIN_VALUE;

        if(arr1p < arr1.length) arr1Target = arr1[arr1p];
        if(arr2p < arr2.length) arr2Target = arr2[arr2p];

        if (arr1Target == Integer.MIN_VALUE) {
            arr2p++;
            return arr2Target;
        }
        if (arr2Target == Integer.MIN_VALUE) {
            arr1p++;
            return arr1Target;
        }

        if (arr1Target > arr2Target) {
            arr2p++;
            return arr2Target;
        } else {
            arr1p++;
            return arr1Target;
        }
    }
}