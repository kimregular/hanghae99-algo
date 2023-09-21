package p11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int people = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            Solution s = new Solution(people, num);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    Queue<Integer> q = new LinkedList<>();
    int num;

    public Solution(int people, int num) {
        this.num = num;
        for (int i = 1; i <= people; i++) {
            this.q.offer(i);
        }
    }

    public String solution() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (q.size() > 1) {
            for (int i = 0; i < num-1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll());
        sb.append(">");

        return sb.toString();
    }
}