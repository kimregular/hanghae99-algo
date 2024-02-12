package p1182;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input data = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(data.getTarget(), data.getArr()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int len = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[len];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return new Input(target, arr);
    }
}

class Input {

    int target;
    int[] arr;

    public Input(int target, int[] arr) {
        this.target = target;
        this.arr = arr;
    }

    public int getTarget() {
        return target;
    }

    public int[] getArr() {
        return arr;
    }
}

class Solution {

    public int solution(int target, int[] arr) {
        Calc c = new Calc(target, arr);
        return c.getAnswer();
    }
    private static class Calc {
        int target;
        int[] arr;

        int answer = 0;

        public Calc(int target, int[] arr) {
            this.target = target;
            this.arr = arr;
        }

        private void DFS(int depth, int sum) {
            if (depth == this.arr.length) {
                if (sum == this.target) {
                    this.answer++;
                }
                return;
            }

            DFS(depth + 1, sum);
            DFS(depth + 1, sum + this.arr[depth]);
        }

        public int getAnswer() {
            DFS(0, 0);
            return this.target == 0 ? this.answer - 1 : this.answer;
        }
    }

}