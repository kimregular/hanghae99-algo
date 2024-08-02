package p13975;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int i = 0; i < TEST_CASE; i++) {
                Solution s = new Solution();
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[] getInput(BufferedReader br) throws IOException {
        br.readLine();
        return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }
}

class Solution {

    public long solution(long[] files) {
        PriorityQueue<Long> pq = getPQ(files);
        long result = 0;
        while (pq.size() > 1) {
            long fileA = pq.poll();
            long fileB = pq.poll();

            long addedFile = fileA + fileB;
            result += addedFile;
            pq.offer(addedFile);
        }
        return result;
    }

    private PriorityQueue<Long> getPQ(long[] nums) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : nums) {
            pq.offer(num);
        }
        return pq;
    }
}