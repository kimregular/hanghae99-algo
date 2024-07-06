package p9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST = Integer.parseInt(br.readLine());
            for (int TEST_CASE = 0; TEST_CASE < TEST; TEST_CASE++) {
                Solution s = new Solution();
                System.out.println(s.solution(getInput(br)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput(BufferedReader br) throws IOException {
        int[] result = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < result[1]; i++) {
            br.readLine();
        }
        return result[0];
    }
}

class Solution {

    public int solution(int n) {
        return n - 1;
    }
}