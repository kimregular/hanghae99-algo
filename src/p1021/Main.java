package p1021;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.len, ip.targetList));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int len = Integer.parseInt(st.nextToken());
        int targetListLen = Integer.parseInt(st.nextToken());

        int[] targetList = new int[targetListLen];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < targetList.length; i++) {
            targetList[i] = Integer.parseInt(st.nextToken());
        }
        return new Input(len, targetList);
    }
}

class Solution {

    public int solution(int len, int[] targetList) {
        Calculator c = new Calculator(len, targetList);
        return c.getAnswer();
    }

    class Calculator {

        LinkedList<Integer> d;
        int[] targetList;
        int answer = 0;

        public Calculator(int len, int[] targetList) {
            LinkedList<Integer> d = new LinkedList<>();
            for (int i = 1; i <= len; i++) {
                d.add(i);
            }
            this.d = d;
            this.targetList = targetList;
        }

        public int getAnswer() {
            calc();
            return this.answer;
        }

        private void calc() {
            for (int target : this.targetList) {
                this.answer += method(target, isRight(target));
            }
        }

        private int method(int target, boolean isRight) {
            int numOfOperationsRepeat = 0;

            while (this.d.getFirst() != target) {
                if (isRight) {
                    this.d.addFirst(d.pollLast());
                } else {
                    this.d.addLast(d.pollFirst());
                }
                numOfOperationsRepeat++;
            }

            this.d.pollFirst();
            return numOfOperationsRepeat;
        }

        private boolean isRight(int target) {
            for (int i = 0; i <= this.d.size() / 2; i++) {
                if(target == this.d.get(i)) return false;
            }
            return true;
        }
    }


}

class Input {

    int len;
    int[] targetList;

    public Input(int len, int[] targetList) {
        this.len = len;
        this.targetList = targetList;
    }
}
