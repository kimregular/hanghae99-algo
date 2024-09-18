package p12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int len = Integer.parseInt(br.readLine());
        int[] result = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        return result;
    }
}

class Solution {

    public String solution(int[] queue) {
        Deque<Integer> stck = new ArrayDeque<>();
        int turn = 1;

        for (int target : queue) {
            if (turn == target) {
                turn++;
            } else {
                while (!stck.isEmpty() && stck.peekLast() == turn) {
                    stck.pollLast();
                    turn++;
                }
                stck.add(target);
            }
        }

        while (!stck.isEmpty() && stck.peekLast() == turn) {
            stck.pollLast();
            turn++;
        }


        return stck.isEmpty() ? "Nice" : "Sad";
    }
}

