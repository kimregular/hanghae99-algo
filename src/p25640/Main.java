package p25640;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.target, ip.mbtis));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        String target = br.readLine();
        int numOfMbtis = Integer.parseInt(br.readLine());
        String[] mbtis = new String[numOfMbtis];
        for (int i = 0; i < numOfMbtis; i++) {
            mbtis[i] = br.readLine();
        }
        return new Input(target, mbtis);
    }

    private static class Input {
        private final String target;
        private final String[] mbtis;

        public Input(String target, String[] mbtis) {
            this.target = target;
            this.mbtis = mbtis;
        }
    }
}

class Solution {

    public int solution(String target, String[] mbtis) {
        return (int) Arrays.stream(mbtis).filter(target::equals).count();
    }
}