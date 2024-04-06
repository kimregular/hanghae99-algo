package p16922;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}


class Solution {

    public int solution(int num) {
        CombinationResolver cr = new CombinationResolver(num);
        return cr.getResult();
    }

    private class CombinationResolver {

        int select;
        int[] combinated;
        int[] group = {1, 5, 10, 50};
        Set<Integer> result = new HashSet<>();

        public CombinationResolver(int num) {
            this.select = num;
            this.combinated = new int[num];
        }

        public int getResult() {
            combinate(0, 0);
            return this.result.size();
        }

        private void combinate(int cnt, int start) {
            if (cnt == this.select) {
                saveCombinated();
                return;
            }

            for (int i = start; i < this.group.length; i++) {
                this.combinated[cnt] = this.group[i];
                combinate(cnt + 1, i);
            }
        }

        private void saveCombinated() {
            int saveNum = 0;
            for (int i : this.combinated) {
                saveNum += i;
            }
            this.result.add(saveNum);
        }
    }

}