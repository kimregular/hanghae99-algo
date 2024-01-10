package p5618;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());

            int[] arr = new int[len];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(getCommonDividor(arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getCommonDividor(int[] nums) {
        StringBuilder answer = new StringBuilder();
        Arrays.sort(nums);

        for (int i = 1; i < nums[nums.length - 1] + 1; i++) {
            int flag = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % i != 0) {
                    flag++;
                }
            }
            if (flag == 0) {
                answer.append(i).append("\n");
            }
        }
        return answer.toString();
    }
}
