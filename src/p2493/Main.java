package p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution solution = new Solution();
            System.out.println(solution.solve(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}

class Solution {

    public String solve(int[] towels) {
        StringBuilder sb = new StringBuilder();
        Stack<Towel> stack = new Stack<>();

        for (int i = 0; i < towels.length; i++) {

            while (!stack.isEmpty() && stack.peek().getHeight() < towels[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(new Towel(towels[i], i));
            } else {
                sb.append(stack.peek().getIdx()).append(" ");
                stack.push(new Towel(towels[i], i));
            }
        }
        return sb.toString();
    }
}

class Towel {

    private final int height;
    private final int idx;

    public Towel(int height, int idx) {
        this.height = height;
        this.idx = idx + 1;
    }

    public int getHeight() {
        return height;
    }

    public int getIdx() {
        return idx;
    }
}