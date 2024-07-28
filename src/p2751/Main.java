package p2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }
        return result;
    }
}

class Solution {

    public String solution(int[] arr) {
        MergeSort ms = new MergeSort(arr);
        return getAnswer(ms.getResult());
    }

    public String getAnswer(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        return sb.toString();
    }
}

class MergeSort {

    int[] arr;
    int[] temp = new int[1_000_001];

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public int[] getResult() {
        mergeSort(0, arr.length);
        return arr;
    }

    private void mergeSort(int start, int end) {
        if(end == start + 1) return;

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid, end);
        merge(start, end);
    }

    private void merge(int start, int end) {
        int mid = (start + end) / 2;
        int lp = start;
        int rp = mid;

        for (int i = start; i < end; i++) {
            if(rp == end) temp[i] = arr[lp++];
            else if (lp == mid) temp[i] = arr[rp++];
            else if (arr[lp] <= arr[rp]) temp[i] = arr[lp++];
            else temp[i] = arr[rp++];
        }
        for (int i = start; i < end; i++) arr[i] = temp[i];
    }
}