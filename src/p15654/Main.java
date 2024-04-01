package p15654;

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
        String[] tokens = br.readLine().split(" ");
        int len = Integer.parseInt(tokens[0]);
        int select = Integer.parseInt(tokens[1]);

        int[] group = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < group.length; i++) {
            group[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(group);

        return new Input(group, select);
    }

    static class Input {

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
        PermutationResolver pr = new PermutationResolver(group, select);
        return pr.getResult();
    }

    private class PermutationResolver {

        int[] group;
        int select;
        int[] permutated;
        boolean[] isUsed;
        StringBuilder result = new StringBuilder();

        public PermutationResolver(int[] group, int select) {
            this.group = group;
            this.select = select;
            this.permutated = new int[select];
            this.isUsed = new boolean[group.length + 1];
        }

        public String getResult() {
            permutate(0);
            return this.result.toString();
        }

        private void permutate(int cnt) {
            if (cnt == this.select) {
                saveResult(this.permutated);
                return;
            }

            for (int i = 0; i < this.group.length; i++) {
                if(this.isUsed[i]) continue;

                this.isUsed[i] = true;
                this.permutated[cnt] = this.group[i];
                permutate(cnt + 1);
                this.isUsed[i] = false;
            }
        }

        private void saveResult(int[] permutated) {
            for (int i : permutated) {
                this.result.append(i).append(" ");
            }
            this.result.append("\n");
        }
    }
}
