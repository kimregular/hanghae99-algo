package p16953BFS;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long num = Long.parseLong(st.nextToken());
            long target = Long.parseLong(st.nextToken());

            Solution s = new Solution(num, target);
            System.out.println(s.BFS());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    long num;
    long target;

    public Solution(long num, long target) {
        this.num = num;
        this.target = target;
    }

    public long BFS() {
        int cnt = 0;
        Queue<Long> q = new LinkedList<>();
        q.offer(num);

        while (!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++){

                long tmp = q.poll();
                if (tmp == target) return cnt+1;
                else {
                    long num1 = tmp * 2;
                    long num2 = tmp * 10 + 1;

                    if(num1 <= target) q.offer(num1);
                    if(num2 <= target) q.offer(num2);
                }
            }
            cnt++;
        }

        return -1;
    }
}
