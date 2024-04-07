package p14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

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

    public int solution(int[] arr) {
        BacktrackResolver br = new BacktrackResolver(arr, getSumOfArr(arr));
        return br.getResult();
    }

    private int getSumOfArr(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result += i;
        }
        return result;
    }

    private class BacktrackResolver{
        int[] arr;
        int[] subset;

        public BacktrackResolver(int[] arr, int sumOfArr) {
            Arrays.sort(arr);
            this.arr = arr;
            this.subset = new int[sumOfArr + 2];
        }

        public int getResult() {
            backtrack(0, 0);
            for (int i = 1; i < this.subset.length; i++) {
                if(this.subset[i] == 0) return i;
            }
            return -1;
        }

        private void backtrack(int cnt, int sum) {
            if (cnt == this.arr.length) {
                saveSum(sum);
                return;
            }

            backtrack(cnt + 1, sum);
            backtrack(cnt + 1, sum + this.arr[cnt]);
        }

        private void saveSum(int sum) {
            this.subset[sum] = 1;
        }
    }
}
