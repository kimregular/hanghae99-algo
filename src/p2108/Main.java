package p2108;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int lenOfNums = Integer.parseInt(br.readLine());
            int[] nums = new int[lenOfNums];
            int total = 0;
            Map<Integer, Integer> mods = new HashMap<>();
            for (int i = 0; i < lenOfNums; i++) {
                int num = Integer.parseInt(br.readLine());
                nums[i] = num;
                total += num;
                mods.put(num, mods.getOrDefault(num, 0) + 1);
            }

            Arrays.sort(nums);
            System.out.println(Math.round((total /(float) lenOfNums)));
            System.out.println(nums[(lenOfNums - 1) / 2]);
            System.out.println(getMods(mods));
            System.out.println(nums[lenOfNums - 1] - nums[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getMods(Map<Integer, Integer> mods) {
        List<Integer> nums = new ArrayList<>();

        int tmpMax = 0;
        for (Map.Entry<Integer, Integer> elem : mods.entrySet()) {
            if (elem.getValue() > tmpMax) {
                tmpMax = elem.getValue();
                nums = new ArrayList<>();
                nums.add(elem.getKey());
            } else if (elem.getValue() == tmpMax) {
                nums.add(elem.getKey());
            }
        }

        nums.sort(Comparator.naturalOrder());
        return nums.size() >= 2 ? nums.get(1) : nums.get(0);
    }
}
