package p14248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.field, ip.startPosition));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] field = new int[len + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < field.length; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }
        int startPosition = Integer.parseInt(br.readLine());
        return new Input(field, startPosition);
    }

    private static class Input {

        int[] field;
        int startPosition;

        public Input(int[] field, int startPosition) {
            this.field = field;
            this.startPosition = startPosition;
        }
    }
}

class Solution {

    public int solution(int[] field, int startPosition) {
        Calculator c = new Calculator(field, startPosition);
        return c.getResult();
    }
}

class Calculator {

    private final Queue<Integer> q = new ArrayDeque<>();
    private final int[] directions = {1, -1};

    private final int[] field;
    private final int startPosition;
    private final boolean[] isVisited;
    private int result = 1;

    public Calculator(int[] field, int startPosition) {
        this.field = field;
        this.startPosition = startPosition;
        this.isVisited = new boolean[field.length];
    }

    public int getResult() {
        explore();
        return result;
    }

    private void explore() {
        q.offer(startPosition);
        isVisited[startPosition] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            moveBackAndForth(cur);
        }
    }

    private void moveBackAndForth(int cur) {
        for (int direction : directions) {
            int nextPosition = cur + (direction * field[cur]);

            if (isValidPosition(nextPosition)) {
                isVisited[nextPosition] = true;
                result++;
                q.offer(nextPosition);
            }
        }
    }

    private boolean isValidPosition(int x) {
        return 1 <= x && x < field.length && !isVisited[x];
    }
}