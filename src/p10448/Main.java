package p10448;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        StringBuilder answer = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TEST_CASE = Integer.parseInt(br.readLine());

            for (int CASE = 0; CASE < TEST_CASE; CASE++) {
                int CASE_NUM = Integer.parseInt(br.readLine());
                Solution s = new Solution(CASE_NUM);
                answer.append(s.isTriangleNum()).append("\n");
            }
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution {

    int CASE_NUM;

    public Solution(int CASE_NUM) {
        this.CASE_NUM = CASE_NUM;
    }

    public int isTriangleNum() {
        for (int x = 1; x <= this.CASE_NUM; x++) {
            for (int y = 1; y <= this.CASE_NUM; y++) {
                for (int z = 1; z <= this.CASE_NUM; z++) {
                    if (getUNum(x) + getUNum(y) + getUNum(z) == this.CASE_NUM) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private int getUNum(int num) {
        return num * (num + 1) / 2;
    }
}