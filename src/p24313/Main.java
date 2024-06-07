package p24313;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = getInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.a1, ip.a0, ip.c, ip.n0));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Input getInput(BufferedReader br) throws IOException {
        String[] tokens = br.readLine().split(" ");
        int a1 = Integer.parseInt(tokens[0]);
        int a0 = Integer.parseInt(tokens[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        return new Input(a1, a0, c, n0);
    }

    private static class Input{

        private final int a1;
        private final int a0;
        private final int c;
        private final int n0;

        public Input(int a1, int a0, int c, int n0) {
            this.a1 = a1;
            this.a0 = a0;
            this.c = c;
            this.n0 = n0;
        }
    }
}

class Solution{

    public int solution(int a1, int a0, int c, int n0) {
        if(isValid(a1, a0, c, n0)) return 1;
        return 0;
    }

    private boolean isValid(int a1, int a0, int c, int n0) {
        int fFunc = a1 * n0 + a0;
        int gFunc = c * n0;
        return a1 <= c && fFunc <= gFunc;
    }
}