package p1920_1;

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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}

class Solution {

    public String solution(int[] arr, int[] target) {
        Arrays.sort(arr);

        StringBuilder answer = new StringBuilder();

        for (int i : target) {
            int lp = 0;
            int rp = arr.length - 1;
            boolean found = false;

            while (lp <= rp) {
                int mid = (lp + rp) / 2;

                if (arr[mid] == i) {
                    answer.append(1).append("\n");
                    found = true;
                    break;
                } else if (arr[mid] < i) {
                    lp = mid + 1;
                } else {
                    rp = mid - 1;
                }
            }

            if (!found) {
                answer.append(0).append("\n");
            }
        }
        return answer.toString();
    }
}