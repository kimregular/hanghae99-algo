package p5800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int i = 0; i < TEST_CASE; i++) {
                Solution s = new Solution();
                result.append(getAnswer(i+1, s.solution(getInput(br)))).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
        return;
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = Integer.parseInt(st.nextToken());

        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    private static String getAnswer(int classNum, int[] scores) {
        int max = scores[0];
        int min = scores[1];
        int largestGap = scores[2];
        StringBuilder answer = new StringBuilder();
        String and = ", ";
        return answer.append("Class ").append(classNum).append("\n").append("Max ").append(max).append(and).append("Min ").append(min).append(and).append("Largest gap ").append(largestGap).toString();
    }
}

class Solution {

    public int[] solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int min = arr[0];
        int largestGap = getLargestGap(arr);

        return new int[]{max, min, largestGap};
    }
    private int getLargestGap(int[] arr) {
        int largestGap = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[i] - arr[i - 1];
            if(tmp > largestGap) largestGap = tmp;
        }
        return largestGap;
    }
}
