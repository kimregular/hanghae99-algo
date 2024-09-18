package p12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        List<Integer> stck = new ArrayList<>();
        int turn = 1;

        for (int i = 0; i < queue.length; i++) {
            int target = queue[i];
            if (turn == target) {
                turn++;
            } else {
                if (!stck.isEmpty()) {
                    while (true) {
                        if(stck.isEmpty()) break;

                        int savedTarget = stck.get(stck.size() - 1);
                        if (savedTarget == turn) {
                            stck.remove(stck.size() - 1);
                            turn++;
                        } else {
                            break;
                        }
                    }
                }
                stck.add(target);
            }
        }

        if (stck.isEmpty()) return "Nice";

        while (!stck.isEmpty()) {
            int target = stck.get(stck.size() - 1);
            stck.remove(stck.size() - 1);

            if (target == turn) {
                turn++;
            } else {
                return "Sad";
            }
        }


        return turn == queue.length + 1 ? "Nice" : "Sad";
    }
}

