package p11508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            System.out.println(s.solution(readInput(br)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Integer> readInput(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            result.add(Integer.parseInt(br.readLine()));
        }
        return result;
    }
}

class Solution {

    public int solution(List<Integer> products) {
        products.sort(Collections.reverseOrder());
        int answer = 0;
        int cnt = 0;
        for (Integer product : products) {
            if (cnt == 2) {
                cnt = 0;
            } else {
                answer += product;
                cnt++;
            }
        }
        return answer;
    }
}