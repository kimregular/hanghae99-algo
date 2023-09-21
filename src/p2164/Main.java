package p2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int target = Integer.parseInt(br.readLine());

            Solution s = new Solution(target);
            System.out.println(s.getSurvivor());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {
    int target;
    Queue<Integer> q = new LinkedList<>();

    public Solution(int target) {
        this.target = target;
        for (int i = 1; i <= target; i++) {
            q.offer(i);
        }
    }

    public int getSurvivor() {
        while (q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }

        return q.poll();
    }
}