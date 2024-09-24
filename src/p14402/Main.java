package p14402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[][] result = new String[len][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = br.readLine().split(" ");
        }
        return result;
    }
}

class Solution {

    public int solution(String[][] records) {
        int result = 0;
        Map<String, Integer> work = new HashMap<>();

        for (String[] record : records) {
            String name = record[0];
            String inAndOut = record[1];

            if (inAndOut.equals("+")) {
                work.put(name, work.getOrDefault(name, 0) + 1);
            } else {
                if (!work.containsKey(name)) {
                    result++;
                } else {
                    Integer isNightWork = work.get(name);
                    if (isNightWork == 0) result++;
                    else work.put(name, isNightWork - 1);
                }
            }
        }

        for (Integer nightWorkPlus : work.values()) {
            result += nightWorkPlus;
        }
        return result;
    }
}