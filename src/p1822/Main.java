package p1822;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.arr1, ip.arr2));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len1 = Integer.parseInt(st.nextToken());
        int len2 = Integer.parseInt(st.nextToken());

        int[] arr1 = getArray(br, len1);
        int[] arr2 = getArray(br, len2);

        return new Input(arr1, arr2);
    }

    private static int[] getArray(BufferedReader br, int len) throws IOException {
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
    static class Input{
        int[] arr1;
        int[] arr2;

        public Input(int[] arr1, int[] arr2) {
            this.arr1 = arr1;
            this.arr2 = arr2;
        }
    }
}

class Solution {

    public String solution(int[] arr1, int[] arr2) {
        return getAnswer(getDiffer(arr1, getSet(arr2)));
    }

    private String getAnswer(List<Integer> list) {
        StringBuilder answer = new StringBuilder();
        if(list.isEmpty()) return "0";

        answer.append(list.size()).append("\n");

        for (int i : list) {
            answer.append(i).append(" ");
        }
        return answer.toString();
    }

    private List<Integer> getDiffer(int[] arr1, Set<Integer> set) {
        List<Integer> result = new ArrayList<>();

        for (int i : arr1) {
            if(!set.contains(i)) result.add(i);
        }
        Collections.sort(result);
        return result;
    }

    private Set<Integer> getSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set;
    }
}
