package p1940;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.threshold, ip.arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int threshold = Integer.parseInt(br.readLine());

        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(threshold, arr);
    }

    private static class Input{

        int threshold;
        int[] arr;

        public Input(int threshold, int[] arr) {
            this.threshold = threshold;
            this.arr = arr;
        }
    }
}

class Solution {

    public int solution(int threshold, int[] arr) {
        Arrays.sort(arr);

        int answer = 0;

        int lp = 0;
        int rp = arr.length - 1;

        while (lp < rp) {
            int curValue = arr[lp] + arr[rp];

            if (curValue < threshold) {
                lp++;
            } else if (curValue > threshold) {
                rp--;
            } else {
                answer++;
                rp--;
                lp++;
            }
        }

        return answer;
    }
}