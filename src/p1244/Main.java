package p1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getSwitches(br), getStudents(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getSwitches(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] switches = new int[len + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < switches.length; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        return switches;
    }

    private static int[][] getStudents(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[][] students = new int[len][2];
        for (int i = 0; i < students.length; i++) {
            int[] student = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            students[i] = student;
        }
        return students;
    }
}

class Solution {

    public String solution(int[] switches, int[][] students) {
        Calculator c = new Calculator(switches, students);
        return c.getSwitches();
    }

    class Calculator {

        int[] switches;
        int[][] students;

        public Calculator(int[] switches, int[][] students) {
            this.switches = switches;
            this.students = students;
        }

        public String getSwitches() {
            calc();
            StringBuilder result = new StringBuilder();
            for (int i = 1; i < this.switches.length; i++) {
                result.append(this.switches[i]);
                if(i % 20 == 0) result.append("\n");
                else if(i != this.switches.length - 1) result.append(" ");
            }
            return result.toString();
        }

        private void calc() {
            for (int[] student : students) {
                if(student[0] == 1) maleOper(student[1]);
                else femaleOper(student[1]);
            }
        }

        private void maleOper(int target) {
            if(target > switches.length) return;
            for (int i = target; i < this.switches.length; i+= target) {
                switchLightBall(i);
            }
        }

        private void femaleOper(int target) {
            if(target > switches.length) return;
            switchLightBall(target);
            int widening = 1;
            while (isConditionMetLightBalls(target - widening, target + widening)) {
                switchLightBall(target - widening);
                switchLightBall(target + widening);
                widening++;
            }
        }

        private boolean isConditionMetLightBalls(int x, int y) {
            return 1 <= x && x < this.switches.length && 1 <= y && y < this.switches.length && this.switches[x] == this.switches[y];
        }

        private void switchLightBall(int target) {
            this.switches[target] = this.switches[target] == 1 ? 0 : 1;
        }
    }
}



