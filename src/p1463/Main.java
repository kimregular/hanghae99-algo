package p1463;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());

            Target target = new Target(num, 0);
            Solution s = new Solution(target);
            System.out.println(s.solution());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    Target target;
    boolean[] isChecked;

    public Solution(Target target) {
        this.target = target;
        this.isChecked = new boolean[target.getX() + 1];
    }

    public int solution() {
        Queue<Target> q = new LinkedList<>();
        q.offer(this.target);
        this.isChecked[this.target.getX()] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Target currentNum = q.poll();

                if (currentNum.getX() == 1) {
                    return currentNum.getNumOfOper();
                }

                if (currentNum.getX() % 3 == 0 && !this.isChecked[currentNum.getX() / 3]) {
                    this.isChecked[currentNum.getX() / 3] = true;
                    q.offer(new Target(currentNum.getX() / 3, currentNum.getNumOfOper() + 1));
                }
                if (currentNum.getX() % 2 == 0 && !this.isChecked[currentNum.getX() / 2]) {
                    this.isChecked[currentNum.getX() / 2] = true;
                    q.offer(new Target(currentNum.getX() / 2, currentNum.getNumOfOper() + 1));
                }
                if (currentNum.getX() - 1 > 0 && !this.isChecked[currentNum.getX() - 1]) {
                    this.isChecked[currentNum.getX() - 1] = true;
                    q.offer(new Target(currentNum.getX() - 1, currentNum.getNumOfOper() + 1));
                }
            }
        }
        return -1;
    }
}

class Target {

    int x;
    int numOfOper;

    public Target(int x, int numOfOper) {
        this.x = x;
        this.numOfOper = numOfOper;
    }

    public int getX() {
        return x;
    }

    public int getNumOfOper() {
        return numOfOper;
    }
}