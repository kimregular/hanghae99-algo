package p20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.arr, ip.limit));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int limit = Integer.parseInt(tokens[1]);

        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(arr, limit);
    }

    private static class Input{
        int limit;
        int[] arr;

        public Input(int[] arr, int limit) {
            this.arr = arr;
            this.limit = limit;
        }
    }
}

class Solution {

    public int solution(int[] arr, int limit) {
        Calculator ca = new Calculator(arr, limit);
        return ca.getMaxLen();
    }

    private class Calculator{
        int[] arr;
        int limit;
        int maxLen = Integer.MIN_VALUE;
        int[] isUsed = new int[200_001];

        public Calculator(int[] arr, int limit) {
            this.arr = arr;
            this.limit = limit;
        }

        public int getMaxLen() {
            calc();
            return this.maxLen;
        }

        private void calc(){

            int rp = 0;

            for(int lp = 0; lp < this.arr.length; lp++) {
                if (lp > 0) this.isUsed[this.arr[lp - 1]]--;
                while (rp < this.arr.length && this.isUsed[this.arr[rp]] < this.limit) {
                    this.isUsed[this.arr[rp++]]++;
                }
                this.maxLen = Math.max(this.maxLen, rp - lp);
                if(rp == this.arr.length) break;
            }
        }
    }
}