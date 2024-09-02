package p11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    public int solution(int[] field) {
        if(field.length ==1) return 1;
        int[] decreaseField = new int[field.length];
        Arrays.fill(decreaseField, 1);

        int result = 1;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < i; j++) {
                if (field[i] < field[j]) {
                    decreaseField[i] = Math.max(decreaseField[i], decreaseField[j] + 1);
                }
            }
            result = Math.max(result, decreaseField[i]);
        }
        return result;
    }
}