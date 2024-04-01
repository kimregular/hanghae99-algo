package p15656;

import java.io.*;
import java.util.*;

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
                savePermutated(this.permutated);
                return;
            }

            for (int i = 0; i < this.group.length; i++) {
                this.permutated[cnt] = group[i];
                permutate(cnt + 1);
            }
        }

        private void savePermutated(int[] permutated) {
            for (int i : permutated) {
                result.append(i).append(" ");
            }
            result.append("\n");
        }
    }
}