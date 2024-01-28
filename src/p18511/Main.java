package p18511;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int limit = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            int[] arr = new int[len];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            Solution s = new Solution();
            System.out.println(s.solution(limit, arr));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int limit, int[] arr) {
        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= limit; i++) {
            if (isAllMatch(i, arr)) {
                answer = i;
            }
        }
        return answer;
    }

    private boolean isAllMatch(int testNum, int[] arr) {
        while (testNum > 0) {
            int item = testNum % 10;
            testNum /= 10;

            if(!contains(item, arr)) return false;
        }
        return true;
    }

    private boolean contains(int x, int[] arr) {
        return indexOf(x, arr) != -1;
    }

    private int indexOf(int x, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x) return i;
        }
        return -1;
    }
}