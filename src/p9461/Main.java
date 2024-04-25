package p9461;

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
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        return arr;
    }
}

class Solution {

    public String solution(int[] arr) {
        List<Long> field = getField(arr);

        StringBuilder answer = new StringBuilder();
        for(int i : arr) answer.append(field.get(i)).append("\n");
        return answer.toString();
    }

    private List<Long> getField(int[] arr) {
        int limit = getMaxElem(arr);
        Long[] defaultValues = {0L, 1L, 1L, 1L, 2L, 2L, 3L, 4L, 5L, 7L, 9L};
        List<Long> lst = new ArrayList<>();
        for(long i : defaultValues) lst.add(i);

        for (int i = defaultValues.length - 1; i < limit + 1; i++) {
            lst.add(lst.get(i) + lst.get(i - 4));
        }
        return lst;
    }

    private int getMaxElem(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }
}
