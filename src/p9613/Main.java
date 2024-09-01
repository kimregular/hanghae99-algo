package p9613;

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
        List<List<Integer>> testCases = new ArrayList<>();
        while(len --> 0) testCases.add(new ArrayList<>());

        for (int i = 0; i < testCases.size(); i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            while(st.hasMoreTokens()) testCases.get(i).add(Integer.parseInt(st.nextToken()));
        }
        return testCases;
    }
}

class Solution {

    StringBuilder answer = new StringBuilder();

    public String solution(List<List<Integer>> testCases) {
        for (List<Integer> testCase : testCases) {
            answer.append(getSumGDC(testCase)).append("\n");
        }
        return answer.toString();
    }

    private long getSumGDC(List<Integer> testCase) {
        long sumOfGDC = 0;
        for (int i = 0; i < testCase.size(); i++) {
            for (int j = i+1; j < testCase.size(); j++) {
                int bigger = Math.max(testCase.get(i), testCase.get(j));
                int smaller = Math.min(testCase.get(i), testCase.get(j));
                sumOfGDC += getGDC(bigger, smaller);
            }
        }
        return sumOfGDC;
    }

    private int getGDC(int bigger, int smaller) {
        if(smaller == 0) return bigger;
        return getGDC(smaller, bigger % smaller);
    }
}