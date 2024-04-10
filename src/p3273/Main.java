package p3273;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.arr, ip.target));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        return new Input(arr, target);
    }

    private static class Input{
        int[] arr;
        int target;

        public Input(int[] arr, int target) {
            this.arr = arr;
            this.target = target;
        }
    }
}

class Solution{

    public int solution(int[] arr, int target) {
        Arrays.sort(arr);

        int answer = 0;

        int lp = 0;
        int rp = arr.length - 1;

        while (lp < rp) {
            int curValue = arr[lp] + arr[rp];

            if (curValue < target) {
                lp++;
            } else if (curValue > target) {
                rp--;
            } else {
                answer++;
                lp++;
                rp--;
            }
        }
        return answer;
    }
}