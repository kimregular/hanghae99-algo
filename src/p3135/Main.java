package p3135;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.start, ip.target, ip.savedPosition));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int start = Integer.parseInt(tokens[0]);
        int target = Integer.parseInt(tokens[1]);

        int len = Integer.parseInt(br.readLine());
        int[] savedPosition = new int[len];
        for (int i = 0; i < savedPosition.length; i++) {
            savedPosition[i] = Integer.parseInt(br.readLine());
        }
        return new Input(start, target, savedPosition);
    }

    private static class Input {

        int start;
        int target;
        int[] savedPosition;

        public Input(int start, int target, int[] savedPosition) {
            this.start = start;
            this.target = target;
            this.savedPosition = savedPosition;
        }
    }
}

class Solution {

    public int solution(int start, int target, int[] savedPosition) {
        Calculator c = new Calculator(start, target, savedPosition);
        return c.getResult();
    }
}

class Calculator {

    int start;
    int target;
    boolean[] isChecked;
    Queue<Click> q;

    public Calculator(int start, int target, int[] savedPosition) {
        this.start = start;
        this.target = target;
        this.isChecked = new boolean[1_000];
        this.q = new ArrayDeque<>();
        q.offer(new Click(start, 0));
        isChecked[start] = true;
        for (int position : savedPosition) {
            isChecked[position] = true;
            q.offer(new Click(position, 1));
        }
    }

    public int getResult() {
        while (!q.isEmpty()) {
            Click cur = q.poll();

            if(cur.position == target) return cur.click;
            else move(cur);
        }
        return -1;
    }

    private void move(Click cur) {
        int[] nextPositions = {cur.position + 1, cur.position - 1};

        for (int nextPosition : nextPositions) {
            if (isValid(nextPosition) && !isChecked[nextPosition]) {
                isChecked[nextPosition] = true;
                q.offer(new Click(nextPosition, cur.click + 1));
            }
        }
    }

    private boolean isValid(int position) {
        return 0 <= position && position < 1000;
    }


    private static class Click {

        int position;
        int click;

        public Click(int position, int click) {
            this.position = position;
            this.click = click;
        }
    }
}