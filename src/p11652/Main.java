package p11652;

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

    private static long[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        long[] arr = new long[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        return arr;
    }
}

class Solution{

    public long solution(long[] arr) {
        Map<Long, Long> map = new HashMap<>();

        for (long i : arr) {
            map.put(i, map.getOrDefault(i, 0L) + 1);
        }
        return getKeyOfMaxValue(map);
    }

    private long getKeyOfMaxValue(Map<Long, Long> map) {
        ArrayList<Long> answerCandidate = new ArrayList<>();
        long curMax = 0;
        for (Long key : map.keySet()) {
            if (curMax < map.get(key)) {
                curMax = map.get(key);
                answerCandidate = new ArrayList<>();
                answerCandidate.add(key);
            } else if (curMax == map.get(key)) {
                answerCandidate.add(key);
            }
        }

        Collections.sort(answerCandidate);
        return answerCandidate.get(0);

    }
}