package p9417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

    private static List<List<Integer>> getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        List<List<Integer>> result = new ArrayList<>();
        while(len --> 0) result.add(new ArrayList<>());

        for (int i = 0; i < result.size(); i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) result.get(i).add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }
}

class Solution {

    private final StringBuilder answer = new StringBuilder();

    public String solution(List<List<Integer>> testCases) {

        for (List<Integer> testCase : testCases) {
            answer.append(getMaxGDC(testCase)).append("\n");
        }

        return answer.toString();
    }

    private int getMaxGDC(List<Integer> nums) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;
                int bigger = Math.max(nums.get(i), nums.get(j));
                int smaller = Math.min(nums.get(i), nums.get(j));
                result = Math.max(result, getGDC(bigger, smaller));
            }
        }
        return result;
    }

    private int getGDC(int bigger, int smaller) {
        if(smaller == 0) return bigger;
        return getGDC(smaller, bigger % smaller);
    }
}