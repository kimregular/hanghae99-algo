package p10816_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br), getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}

class Solution {

    public String solution(int[] arr, int[] targets) {
        Arrays.sort(arr);

        StringBuilder answer = new StringBuilder();

        for (int target : targets) {
            int start = getLowerBound(arr, target);
            int end = getUpperBound(arr, target);

            answer.append(end - start).append(" ");
        }
        return answer.toString();
    }

    private int getLowerBound(int[] arr, int target) {
        int lp = 0;
        int rp = arr.length;

        while(lp < rp) {
            int mid = (lp + rp) / 2;

            if (arr[mid] >= target) {
                rp = mid;
            } else {
                lp = mid + 1;
            }
        }
        return rp;
    }

    private int getUpperBound(int[] arr, int target) {
        int lp = 0;
        int rp = arr.length;

        while(lp < rp) {
            int mid = (lp + rp) / 2;

            if (arr[mid] <= target) {
                lp = mid + 1;
            } else {
                rp = mid;
            }
        }

        return rp;
    }
}
