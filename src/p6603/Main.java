package p6603;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int len = Integer.parseInt(st.nextToken());
                if(len == 0) break;

                Solution s = new Solution();
                System.out.println(s.solution(getInput(st, len)));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(StringTokenizer st, int len) {
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}

class Solution {

    public String solution(int[] arr) {
        CombinationResolver pr = new CombinationResolver(arr);
        return pr.getResult();
    }

    private class CombinationResolver {

        int[] group;
        int select = 6;
        int[] combinated = new int[6];

        StringBuilder result = new StringBuilder();

        public CombinationResolver(int[] group) {
            this.group = group;
        }

        public String getResult() {
            combinate(0, 0);
            return this.result.toString();
        }

        private void combinate(int cnt, int start) {
            if (cnt == this.select) {
                saveCombinated();
                return;
            }

            for (int i = start; i < this.group.length; i++) {
                this.combinated[cnt] = this.group[i];
                combinate(cnt + 1, i + 1);
            }
        }

        private void saveCombinated() {
            for (int i : this.combinated) {
                this.result.append(i).append(" ");
            }
            this.result.append("\n");
        }
    }

}
