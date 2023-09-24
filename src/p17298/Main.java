package p17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Solution s = new Solution(len, st);

            System.out.println(s.NGE());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int len;
    StringTokenizer st;

    public Solution(int len, StringTokenizer st) {
        this.len = len;
        this.st = st;
    }

    public String NGE() {
        Stack<Point> stk = new Stack<>();
        int[] indexContainer = new int[len];


        int idx = 0;
        for (int i = 0; i < len; i++) {
            Point tmp = new Point(Integer.parseInt(st.nextToken()), idx++);

            while (!stk.isEmpty() && stk.peek().getNum() < tmp.getNum()) {
                Point nge = stk.pop();
                indexContainer[nge.getIdx()] = tmp.getNum();
            }

            stk.push(tmp);
        }

        while (!stk.isEmpty()) {
            Point tmp = stk.pop();
            indexContainer[tmp.getIdx()] = -1;
        }

        StringBuilder answer = new StringBuilder();
        for (int i : indexContainer) {
            answer.append(i).append(" ");
        }
        return answer.toString();
    }


    class Point {
        int num;
        int idx;

        public Point(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        public int getNum() {
            return num;
        }

        public int getIdx() {
            return idx;
        }
    }
}
