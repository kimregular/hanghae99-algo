package p18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solve(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}

class Solution {

    public String solve(int[] arr) {
        StringBuilder answer = new StringBuilder();

        int[] compressedArray = compress(arr);

        for (int i : arr) {
            int index = getLowerBound(compressedArray, i);
            answer.append(index).append(" ");
        }
        return answer.toString();
    }

    private int getLowerBound(int[] arr, int target) {
        int lp = 0;
        int rp = arr.length;

        while(lp < rp) {
            int mid = (lp + rp) / 2;

            if (arr[mid] < target) {
                lp = mid + 1;
            } else {
                rp = mid;
            }
        }
        return rp;
    }

    private int[] compress(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int[] result = new int[set.size()];
        int idx = 0;
        for (Integer i : set) {
            result[idx++] = i;
        }
        return result;
    }
}