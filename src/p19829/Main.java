package p19829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());
        int colors = Integer.parseInt(st.nextToken()); // 해당 변수는 필요 없음
        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}

class Solution {

    public int solution(int[] arr) {
        int maxLen = 0;
        int curColor = -1;
        int curLen = 1;

        for (int i = 0; i < arr.length; i++) {
            int nextColor = arr[i];

            if (curColor == nextColor) {
                curLen = 1;
            }
            maxLen = Math.max(maxLen, curLen++);
            curColor = nextColor;
        }
        return maxLen;
    }
}