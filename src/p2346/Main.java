package p2346;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());
            int[] arr = new int[len];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Solution s = new Solution();
            System.out.println(s.solution(arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution{

    public String solution(int[] arr) {
        StringBuilder answer = new StringBuilder();

        Deque<Balloon> dq = new ArrayDeque<>();

        int idx = 1;
        for (int x : arr) {
            dq.add(new Balloon(idx++, x));
        }

        while (!dq.isEmpty()) {
            Balloon currentBalloon = dq.pollFirst();
            int direction = currentBalloon.getValue();

            if (dq.isEmpty()) {
                answer.append(currentBalloon.getNum());
                return answer.toString();
            }

            if (direction >= 0) {
                for (int i = 0; i < direction - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < (direction * -1); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
            answer.append(currentBalloon.getNum()).append(" ");
        }
        return answer.toString();
    }
}

class Balloon {

    int num;
    int value;

    public Balloon(int num, int value) {
        this.num = num;
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public int getValue() {
        return value;
    }
}