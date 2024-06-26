package p12761;

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

    private static int[] getInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Solution {

    public int solution(int[] ip) {
        int powerA = ip[0];
        int powerB = ip[1];
        int position = ip[2];
        int target = ip[3];

        Calculator c = new Calculator(powerA, powerB, position, target);
        return c.getResult();
    }

    private class Calculator {

        int powerA;
        int powerB;
        int position;
        int target;
        int[] isVisited;

        public Calculator(int powerA, int powerB, int position, int target) {
            this.powerA = powerA;
            this.powerB = powerB;
            this.position = position;
            this.target = target;
            this.isVisited = new int[100_001];
            Arrays.fill(isVisited, 100_001);
        }

        public int getResult() {
            BFS();
            return isVisited[target];
        }

        private void BFS() {
            Queue<Location> q = new ArrayDeque<>();
            q.offer(new Location(position, 0));
            isVisited[position] = 0;

            while (!q.isEmpty()) {
                Location currentLocation = q.poll();
                int currentPosition = currentLocation.position;
                int currentStep = currentLocation.step;

                takeNextStep(q, currentPosition, currentStep);
            }
        }

        private void takeNextStep(Queue<Location>  q, int currentPosition, int currentStep) {
            int step1 = currentPosition - 1;
            int step2 = currentPosition + 1;

            int step3 = currentPosition - powerA;
            int step4 = currentPosition + powerA;

            int step5 = currentPosition - powerB;
            int step6 = currentPosition + powerB;

            int step7 = currentPosition * powerA;
            int step8 = currentPosition * powerB;

            int[] nextSteps = {step1, step2, step3, step4, step5, step6, step7, step8};

            for (int nextStep : nextSteps) {
                if (isWithinValidField(nextStep, currentStep + 1)) {
                    isVisited[nextStep] = currentStep + 1;
                    q.offer(new Location(nextStep, currentStep + 1));
                }
            }
        }

        private boolean isWithinValidField(int x, int nextStep) {
            return 0 <= x && x < isVisited.length && isVisited[x] > nextStep;
        }

        private class Location {

            int position;
            int step;

            public Location(int position, int step) {
                this.position = position;
                this.step = step;
            }
        }
    }
}