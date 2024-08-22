package p15312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(getInput(br), getInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static char[] getInput(BufferedReader br) throws IOException {
        return br.readLine().toCharArray();
    }
}

class Solution {

    int[] scores = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public String solution(char[] his, char[] her) {
        return getAnswer(process(getScoredName(his, her)));
    }

    private int[] getScoredName(char[] his, char[] her) {
        int[] result = new int[his.length + her.length];

        for (int i = 0; i < his.length; i++) {
            result[2 * i] = scores[his[i] - 'A'];
            result[2 * i + 1] = scores[her[i] - 'A'];
        }

        return result;
    }

    private int[] process(int[] nameScore) {
        int repeat = nameScore.length;
        while (repeat > 2) {
            for (int i = 0; i < repeat - 1; i++) {
                nameScore[i] = (nameScore[i] + nameScore[i + 1]) % 10;
            }
            repeat--;
        }
        return nameScore;
    }

    private String getAnswer(int[] nameScore) {
        return "" + nameScore[0] + nameScore[1];
    }
}
