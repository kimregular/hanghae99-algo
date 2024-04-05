package p15665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.group, ip.select));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());
        int select = Integer.parseInt(st.nextToken());

        int[] group = new int[len];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < group.length; i++) {
            group[i] = Integer.parseInt(st.nextToken());
        }

        return new Input(group, select);
    }

    private static class Input {

        int[] group;
        int select;

        public Input(int[] group, int select) {
            this.group = group;
            this.select = select;
        }
    }
}

class Solution {

    public String solution(int[] group, int select) {
        Arrays.sort(group);
        PermutationResolver pr = new PermutationResolver(group, select);
        return pr.getResult();
    }

    private class PermutationResolver {

        int[] group;
        int select;
        int[] permutated;

        StringBuilder result = new StringBuilder();

        public PermutationResolver(int[] group, int select) {
            this.group = group;
            this.select = select;
            this.permutated = new int[select];
        }

        public String getResult() {
            permutate(0);
            return this.result.toString();
        }

        private void permutate(int cnt) {
            if (cnt == this.select) {
                savePermutated();
                return;
            }

            int prevNum = -1;
            for (int i = 0; i < this.group.length; i++) {
                if(prevNum == this.group[i]) continue;

                prevNum = this.group[i];
                this.permutated[cnt] = this.group[i];
                permutate(cnt + 1);
            }
        }

        private void savePermutated() {
            for (int i : this.permutated) {
                this.result.append(i).append(" ");
            }
            this.result.append("\n");
        }
    }
}
