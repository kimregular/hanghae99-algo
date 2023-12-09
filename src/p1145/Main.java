package p1145;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] nums = new int[5];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            CommonMultipleFinder cmf = new CommonMultipleFinder(nums);
            System.out.println(cmf.findCommonMultiple());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


class CommonMultipleFinder {

    int[] nums;
    int start;

    public CommonMultipleFinder(int[] nums) {
        this.nums = nums;
        int tmp = Integer.MAX_VALUE;
        for (int num : nums) {
            tmp = Math.min(tmp, num);
        }
        this.start = tmp;
    }

    public int findCommonMultiple() {
        int count = 0;

        for (int i = this.start; i < Integer.MAX_VALUE - 2; i++) {
            count = 0;
            int commonMultiple = i;

            for (int num : this.nums) {
                if (commonMultiple % num == 0) {
                    count++;
                }
            }

            if (count >= 3) return commonMultiple;
        }
        return -1;
    }
}