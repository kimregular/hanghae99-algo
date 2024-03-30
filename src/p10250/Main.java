package p10250;

import java.io.*;

public class Main {

    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int TEST_CASE = Integer.parseInt(br.readLine());
            for (int i = 0; i < TEST_CASE; i++) {
                int[] ip = getInput(br);
                Solution s = new Solution();
                System.out.println(s.solution(ip[0], ip[1], ip[2]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int[] result = new int[3];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(ip[i]);
        }
        return result;
    }
}

class Solution {

    public String solution(int H, int W, int N) {

        int height = N%H == 0 ? H : N%H;
        int roomNumber = N%H == 0 ? N/H : N/H + 1;

        StringBuilder answer = new StringBuilder();
        answer.append(height);

        if(roomNumber < 10) answer.append("0").append(roomNumber);
        else answer.append(roomNumber);

        return answer.toString();
    }
}