package p13913;

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
        String[] tokens = br.readLine().split(" ");
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        return new int[]{x, y};
    }
}

class Solution {

    int[] board = new int[400_000];

    public String solution(int[] coor) {
        Arrays.fill(board, -1);
        findSister(coor[0], coor[1]);
        Stack<Integer> stck = new Stack<>();
        stck.push(coor[1]);
        int idx = coor[1];
        while (idx != coor[0]) {
            stck.push(board[idx]);
            idx = board[idx];
        }
        return getAnswer(stck);
    }

    private String getAnswer(Stack<Integer> stck) {
        StringBuilder answer = new StringBuilder();

        answer.append(stck.size() - 1).append("\n");
        while (!stck.isEmpty()) {
            answer.append(stck.pop()).append(" ");
        }

        return answer.toString();
    }

    private void findSister(int subin, int sister) {
        board[subin] = subin;
        Queue<Subin> q = new LinkedList<>();
        q.offer(new Subin(subin));

        while (!q.isEmpty()) {
            Subin currentSubin = q.poll();

            if (currentSubin.position == sister) {
                return;
            }


            for (int nextDestination : currentSubin.getNextPositons()) {
                if (isReachable(nextDestination)) {
                    this.board[nextDestination] = currentSubin.position;
                    q.offer(new Subin(nextDestination));
                }
            }
        }
    }

    private boolean isReachable(int x) {
        return 0 <= x && x < 200_000 && this.board[x] == -1;
    }

    private class Subin{
        int position;

        public Subin(int position) {
            this.position = position;
        }

        public int[] getNextPositons() {
            return new int[]{this.position - 1, this.position + 1, this.position * 2};
        }
    }
}