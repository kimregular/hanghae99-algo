package p1806;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.arr, ip.threshold));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int threshold = Integer.parseInt(tokens[1]);

        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(arr, threshold);
    }

    private static class Input {

        int[] arr;
        int threshold;

        public Input(int[] arr, int threshold) {
            this.arr = arr;
            this.threshold = threshold;
        }
    }
}

class Solution {

    public int solution(int[] arr, int threshold) {
        int answer = Integer.MAX_VALUE;

        int rp = 0;
        int curValue = arr[0];
        for (int lp = 0; lp < arr.length; lp++) {
            while (rp < arr.length && curValue < threshold) {
                rp++;
                if(rp != arr.length) curValue += arr[rp];
            }
            if(rp == arr.length) break;
            answer = Math.min(answer, rp - lp + 1);
            curValue -= arr[lp];
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
