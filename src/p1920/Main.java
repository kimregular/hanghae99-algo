package p1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br), getInput(br)));

        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        return result;
    }
}

class Solution {

    public String solution(int[] arr1, int[] arr2) {
        return getAnswer(getSet(arr1), arr2);
    }

    private Set<Integer> getSet(int[] arr) {
        Set<Integer> set = new HashSet<>(arr.length);
        for(int i : arr) set.add(i);
        return set;
    }

    private String getAnswer(Set<Integer> set, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(set.contains(i) ? "1" : "0").append("\n");
        }
        return sb.toString();
    }
}
