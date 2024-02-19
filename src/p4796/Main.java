package p4796;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Solution s = new Solution();
            int num = 1;

            while (true) {
                int[] ip = getInput(br);

                if (ip[0] == 0 && ip[1] == 0 && ip[2] == 0) {
                    break;
                }

                System.out.println("Case " + num + ": " + s.solution(ip[0], ip[1], ip[2]));
                num++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInput(BufferedReader br) throws IOException {
        String[] data = br.readLine().split(" ");
        int L = Integer.parseInt(data[0]);
        int P = Integer.parseInt(data[1]);
        int V = Integer.parseInt(data[2]);

        return new int[]{L, P, V};
    }
}

class Solution {

    public int solution(int L, int P, int V) {
        int answer = 0;

        while (V > 0) {
            if (V < P) {
                answer += Math.min(L, V);
                break;
            }
            answer += L;
            V -= P;
        }

        return answer;
    }
}