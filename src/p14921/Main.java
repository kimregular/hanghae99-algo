package p14921;

import java.io.*;
import java.util.*;

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

class Solution{

    public int solution(int[] arr) {
        int answer = Integer.MAX_VALUE;
        int lp = 0;
        int rp = arr.length - 1;

        while (lp < rp) {
            if (Math.abs(answer) >= Math.abs(arr[lp] + arr[rp])) {
                answer = arr[lp] + arr[rp];
            }
            if(arr[lp] + arr[rp] < 0) lp++;
            else rp--;
        }
        return answer;
    }
}