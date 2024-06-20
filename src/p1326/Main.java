package p1326;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.bridge, ip.initialPoint));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] bridge = new int[len + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < bridge.length; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        int[] initialPoint = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return new Input(bridge, initialPoint);
    }

    private static class Input{

        int[] bridge;
        int[] initialPoint;

        public Input(int[] bridge, int[] initialPoint) {
            this.bridge = bridge;
            this.initialPoint = initialPoint;
        }
    }
}

class Solution {

    public int solution(int[] bridge, int[] initialPoint) {
        Calculator c = new Calculator(bridge, initialPoint);
        return c.getResult();
    }

    private static class Calculator {

        int[] bridge;
        boolean[] isVisited;
        int startPoint;
        int targetPoint;

        public Calculator(int[] bridge, int[] initialPoint) {
            this.bridge = bridge;
            this.startPoint = initialPoint[0];
            this.targetPoint = initialPoint[1];
            this.isVisited = new boolean[bridge.length];
        }

        public int getResult() {
            return explore();
        }

        private int explore() {
            Queue<Step> q = new ArrayDeque<>();
            q.offer(new Step(startPoint, 0));
            isVisited[startPoint] = true;

            while (!q.isEmpty()) {
                Step currentPosition = q.poll();
                int curPoint = currentPosition.point;
                int curStep = currentPosition.steps;
                int jumpRange = bridge[curPoint];

                if(curPoint == targetPoint) return curStep;

                BFS(q, curPoint, curStep, jumpRange, true);
                BFS(q, curPoint, curStep, jumpRange, false);
            }
            return -1;
        }

        private void BFS(Queue<Step> q, int curPoint, int curStep, int jumpRange, boolean forward) {
            int nextPoint = curPoint;
            while (true) {
                nextPoint += forward ? jumpRange : -jumpRange;

                if (nextPoint < 1 || nextPoint >= bridge.length) {
                    break;
                }
                if (isVisited[nextPoint]) {
                    continue;
                }

                isVisited[nextPoint] = true;
                q.offer(new Step(nextPoint, curStep + 1));
            }
        }

        private class Step{
            int point;
            int steps;

            public Step(int point, int steps) {
                this.point = point;
                this.steps = steps;
            }
        }

    }
}