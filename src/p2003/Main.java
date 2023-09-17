package p2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int LEN = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int[] arr = new int[LEN];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < LEN; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution();
            System.out.println(s.solution(arr, target));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    public int solution(int[] arr, int tartget) {
        int answer = 0;
        int sum = 0;

        int lp = 0;
        int rp = 0;

        while (rp < arr.length) {

            if (sum < tartget) {
                sum += arr[rp++];
            }
            else if (sum > tartget) {
                sum -= arr[lp++];
            }

            if (sum == tartget) {
                answer++;
                sum -= arr[lp++];
            }

        }

        if (sum > tartget) {

            do {
                sum -= arr[lp++];
                if (sum == tartget) {
                    answer++;
                }
            } while (lp < arr.length);
        }

        return answer;
    }
}