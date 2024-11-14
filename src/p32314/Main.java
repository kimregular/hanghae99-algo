package p32314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Input ip = readInput(br);
            Solution s = new Solution();
            System.out.println(s.solution(ip.ampere, ip.watt, ip.volt));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readInput(BufferedReader br) throws IOException {
        int ampere = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        int watt = Integer.parseInt(tokens[0]);
        int volt = Integer.parseInt(tokens[1]);
        return new Input(ampere, watt, volt);
    }

    private static class Input {
        private final int ampere;
        private final int watt;
        private final int volt;

        public Input(int ampere, int watt, int volt) {
            this.ampere = ampere;
            this.watt = watt;
            this.volt = volt;
        }
    }
}

class Solution {

    public int solution(int ampere, int watt, int volt) {
        return valid(ampere, watt, volt) ? 1 : 0;
    }

    private boolean valid(int ampere, int watt, int volt) {
        return ampere <= watt / volt;
    }
}