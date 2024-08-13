package p2910;

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
        br.readLine();
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Solution {

    public String solution(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i});
            } else {
                map.get(nums[i])[0]++;
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            if (map.get(o1)[0] != map.get(o2)[0]) {
                return Integer.compare(map.get(o2)[0], map.get(o1)[0]);
            }

            return Integer.compare(map.get(o1)[1], map.get(o2)[1]);
        });

        return getResult(map, list);
    }

    private String getResult(Map<Integer, int[]> map, List<Integer> list) {
        StringBuilder result = new StringBuilder();
        for (int num : list) {
            int freq = map.get(num)[0];
            for (int i = 0; i < freq; i++) {
                result.append(num).append(" ");
            }
        }
        return result.toString();
    }
}
