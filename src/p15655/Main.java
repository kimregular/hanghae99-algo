package p15655;

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
        CombinationResolver cr = new CombinationResolver(group, select);
        return cr.getResult();
    }

    private class CombinationResolver {

        int[] group;
        int select;

        int[] combinated;

        StringBuilder result = new StringBuilder();

        public CombinationResolver(int[] group, int select) {
            this.group = group;
            this.select = select;
            this.combinated = new int[select];
        }

        public String getResult() {
            combinate(0, 0);
            return this.result.toString();
        }

        private void combinate(int cnt, int start) {
            if (cnt == this.select) {
                saveCombinated(this.combinated);
                return;
            }

            for (int i = start; i < this.group.length; i++) {
                this.combinated[cnt] = this.group[i];
                combinate(cnt + 1, i + 1);
            }
        }


        private void saveCombinated(int[] combinated) {
            for (int i : combinated) {
                this.result.append(i).append(" ");
            }
            this.result.append("\n");
        }
    }
}
