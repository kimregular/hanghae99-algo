package p29863;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip[0], ip[1]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        int sleep = Integer.parseInt(br.readLine());
        int awake = Integer.parseInt(br.readLine());

        return new int[]{sleep, awake};
    }
}

class Solution {

    public int solution(int sleep, int awake) {
        if(sleep <= 3) return awake - sleep;
        return 24 - sleep + awake;
    }
}